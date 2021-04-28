package tests.demoqa.pageobjects.scenarios;

import tests.demoqa.pageobjects.domain.FormData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public void fillForm(FormData data) {
        $("#firstName").val(data.getFirstName());
        $("#lastName").val(data.getLastName());
        $("#userEmail").val(data.getEmail());
        $("#genterWrapper").$(byText(data.getGender())).click();
        $("#userNumber").val(data.getMobile());
        // set date
        setBirthDate(data);
        // set subject
        $("#subjectsInput").val(data.getSubject1());
        $(".subjects-auto-complete__menu-list").$(byText(data.getSubject1())).click();
        $("#subjectsInput").val(data.getSubject2());
        $(".subjects-auto-complete__menu-list").$(byText(data.getSubject2())).click();
        // set hobbies
        $("#hobbiesWrapper").$(byText(data.getHobby1())).click();
        $("#hobbiesWrapper").$(byText(data.getHobby2())).click();
        $("#hobbiesWrapper").$(byText(data.getHobby3())).click();
        // upload image
        $("#uploadPicture").uploadFromClasspath("img/" + data.getPicture());
        // set current address
        $("#currentAddress").val(data.getCurrentAddress());
        // set state and city
        $("#state").click();
        $("#stateCity-wrapper").$(byText(data.getState())).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(data.getCity())).click();

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void setBirthDate(FormData formData) {
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(formData.getMonthOfBirth());
        $(".react-datepicker__year-select").selectOption(formData.getYearOfBirth());
        $(".react-datepicker__day--0" + formData.getDayOfBirth()).click();
    }

    public void checkData(FormData data) {
        $x("//td[text()='Student Name']").parent().shouldHave(text(data.getFirstName() + " " + data.getLastName()));
        $x("//td[text()='Student Email']").parent().shouldHave(text(data.getEmail()));
        $x("//td[text()='Gender']").parent().shouldHave(text(data.getGender()));
        $x("//td[text()='Mobile']").parent().shouldHave(text(data.getMobile()));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(data.getDayOfBirth() + " " + data.getMonthOfBirth() + "," + data.getYearOfBirth()));
        $x("//td[text()='Subjects']").parent().shouldHave(text(data.getSubject1() + ", " + data.getSubject2()));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(data.getHobby1() + ", " + data.getHobby2() + ", " + data.getHobby3()));
        $x("//td[text()='Picture']").parent().shouldHave(text(data.getPicture()));
        $x("//td[text()='Address']").parent().shouldHave(text(data.getCurrentAddress()));
        $x("//td[text()='State and City']").parent().shouldHave(text(data.getState() + " " + data.getCity()));
    }
}