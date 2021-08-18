package tests;

import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void setup(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void formTest(){
        open("/automation-practice-form");      // Открываем сайт
        $("#firstName").setValue("Alex");              // Вводим имя
        $("#lastName").setValue("Djabuddinov");        // Вводим фамилию
        $("#userEmail").setValue("google@yamail.com"); // Вводим мыло
        //sleep(5000);
        $("[for = 'gender-radio-1']").click();          // Выбираем пол
        $("#userNumber").setValue("0123456789");        // Номер
        $("#dateOfBirthInput").click();                 // Дата рождения
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--028").click();
        $("#subjectsInput").click();                     // Выбираем предмет
        $("#subjectsInput").setValue("Physics").pressEnter();
        $("[for = 'hobbies-checkbox-1']").click();       // Выбираем хобби
        $("#uploadPicture").uploadFile(new File("avatars.jpg")); //Загружаем файл
        $("#currentAddress").setValue("Adress");         // Вводим адрес
        $("#react-select-3-input").setValue("NCR").pressEnter(); // Штат
        $("#react-select-4-input").setValue("Delhi").pressEnter(); // Город
        $("#submit").click();                            // Отправить
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form")); // Проверка




        sleep(10000);
    }
}
