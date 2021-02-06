package tests.pageobjects.steps;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class StudentRegistrationPage {
    private SelenideElement pageHeader = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName");

    public void checkPageHeader(String value) {
        pageHeader.shouldHave(text(value));
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }
}