package ru.juli.practicum;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.juli.practicum.pageoption.HomePageScooter;

import java.util.ArrayList;
import static org.junit.Assert.*;

public class TestListQuestionsImportant {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Администратор\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkList() throws InterruptedException {

        driver.get("http://qa-scooter.praktikum-services.ru");

        // объект класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        // нажимаем принять куки
        objHomePage.clickButtonCookie();
        //найти и прокрутить до списка
        objHomePage.scrollToFaq();

        ArrayList<WebElement> listFaq = objHomePage.findListFaq();
        for (int i = 0; i < listFaq.size(); i++) {
            objHomePage.clickHeadingFaq(listFaq.get(i));
            assertEquals(objHomePage.isVisible(listFaq.get(i)), "true");
        }
    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}