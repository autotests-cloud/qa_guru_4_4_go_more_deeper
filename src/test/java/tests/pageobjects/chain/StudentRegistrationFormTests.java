package tests.pageobjects.chain;

import org.junit.jupiter.api.Test;
import tests.TestBase;

public class StudentRegistrationFormTests extends TestBase {
    StudentRegistrationPage studentRegistrationPage;

    @Test
    void successfulFillFormTest() {
        studentRegistrationPage = new StudentRegistrationPage();

        studentRegistrationPage.openPage()
                .fillForm()
                .checkData();
    }
}
