package tests.demoqa.pageobjects.scenarios;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tests.TestBase;
import tests.demoqa.pageobjects.domain.FormData;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class StudentRegistrationFormTests extends TestBase {

    StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();

    @BeforeEach
    void setup() {
        studentRegistrationPage.openPage();
    }

    static Stream<Arguments> successfulFillFormTest0() {
        return Stream.of(
                Arguments.of(
                        FormData.builder()
                                .firstName("Alex")
                                .lastName("Alexov")
                                .email("aa@aa.com")
                                .gender("Other")
                                .mobile("1234567890")
                                .dayOfBirth("10")
                                .monthOfBirth("May")
                                .yearOfBirth("1988")
                                .subject1("Chemistry")
                                .subject2("Commerce")
                                .hobby1("Sports")
                                .hobby2("Reading")
                                .hobby3("Music")
                                .picture("1.png")
                                .currentAddress("Montenegro 123")
                                .state("Uttar Pradesh")
                                .city("Merrut")
                                .build()
                ),
                Arguments.of(
                        FormData.builder()
                                .firstName("Alex")
                                .lastName("Alexov")
                                .email("aa@aa.com")
                                .gender("Other")
                                .mobile("1234567890")
                                .dayOfBirth("10")
                                .monthOfBirth("May")
                                .yearOfBirth("1988")
                                .subject1("Chemistry")
                                .subject2("Commerce")
                                .hobby1("Sports")
                                .hobby2("Reading")
                                .hobby3("Music")
                                .picture("1.png")
                                .currentAddress("Montenegro 123")
                                .state("Uttar Pradesh")
                                .city("Merrut")
                                .build()
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Check form for data: {1}")
    void successfulFillFormTest0(FormData data) {
        studentRegistrationPage.fillForm(data);
        studentRegistrationPage.checkData(data);
    }

    @Test
    void streamExample() {
        List<String> names = asList("Вася", "Петя");
        for (String name : names) {
            System.out.println(name.toUpperCase());
        }

        Stream.of("Вася", "Петя").parallel()
                .map(el -> el.toUpperCase())
                .forEach(el -> System.out.println(el));
    }
}
