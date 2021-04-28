package tests.demoqa.pageobjects.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class FormData {

    private String
            firstName,
            lastName,
            email,
            gender,
            mobile,
            dayOfBirth,
            monthOfBirth,
            yearOfBirth,
            subject1,
            subject2,
            hobby1,
            hobby2,
            hobby3,
            picture,
            currentAddress,
            state,
            city;

    @Override
    public String toString() {
        return "FormData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
