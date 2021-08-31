package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class FormTest {

    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    RandomUtils utils = new RandomUtils();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = faker.demographic().sex();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String day = "28";
    String month = "6";
    String year = "1990";
    String subject = utils.getRandomSubject();
    String hobby = utils.getRandomHobby();
    String pathname = "avatars.jpg";
    String address = faker.address().streetAddress();
    String state = "NCR";
    String city = "Delhi";


    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void formTest() {

        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGender(gender)
                .typePhone(phoneNumber)
                .setDateOfBirth(day, month, year)
                .selectSubject(subject)
                .selectHobby(hobby)
                .uploadFile(pathname)
                .enterAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm()
                .checkResultsTitle()
                .checkResultsValue(firstName + " " + lastName)
                .checkResultsValue(email)
                .checkResultsValue(gender)
                .checkResultsValue(phoneNumber)
                .checkResultsValue(day + " July" + "," + year)
                .checkResultsValue(subject)
                .checkResultsValue(hobby)
                .checkResultsValue("avatars.jpg")
                .checkResultsValue(address)
                .checkResultsValue(state + " " + city);


    }
}
