package tests.demoqa;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StudentRegistrationFormWithElementsCollectionTests extends TestBase {

    static Faker faker = new Faker();
    static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Other",
            mobile = "1234123412",
            dayOfBirth = "10",
            monthOfBirth = "May",
            yearOfBirth = "1988",
            subject1 = "Chemistry",
            subject2 = "Commerce",
            hobby1 = "Sports",
            hobby2 = "Reading",
            hobby3 = "Music",
            picture = "1.png",
            currentAddress = faker.address().fullAddress(),
            state = "Uttar Pradesh",
            city = "Merrut";

    static Map<String, String> expectedData  = new HashMap<>() {{
        put("Student Name", firstName + " " + lastName);
        put("Student Email", email);
        put("Gender", gender);
        put("Mobile", mobile);
        put("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth);
        put("Subjects", subject1 + ", " + subject2);
        put("Hobbies", "wrong Hobbies");
        put("Picture", "1.png");
        put("Address", "wrong Address");
        put("State and City", "wrong State and City");
    }};

    @Test
    void successfulFillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $(byText(gender)).click();
        $("#userNumber").val(mobile);
        // set date
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__day--0" + dayOfBirth).click();
        // set subject
        $("#subjectsInput").setValue(subject1).pressEnter();
//        $(".subjects-auto-complete__menu-list").$(byText(subject1)).click();
        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();
        // set hobbies
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
        // upload image
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
        // set current address
        $("#currentAddress").val(currentAddress);
        // set state and city
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        // asserts
        SoftAssertions softly = new SoftAssertions();
        for(SelenideElement element: $$(".table-responsive tbody tr").snapshot()) {
            String key = element.$("td").getText();
            String actualValue = element.$("td", 1).getText();
            String expectedValue = expectedData.get(key);

            softly.assertThat(actualValue).isEqualTo(expectedValue);
        }
        softly.assertAll();
    }
}
