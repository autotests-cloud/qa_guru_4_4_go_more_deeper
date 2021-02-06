package tests.pageobjects.scenarios;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests extends TestBase {
    StudentRegistrationPage studentRegistrationPage;

    @Test
    void successfulFillFormTest() {
        studentRegistrationPage = new StudentRegistrationPage();

        studentRegistrationPage.openPage();
        studentRegistrationPage.fillForm();
        studentRegistrationPage.checkData();
    }
}
