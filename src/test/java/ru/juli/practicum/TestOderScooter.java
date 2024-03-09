package ru.juli.practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import ru.juli.practicum.pageoption.HomePageScooter;
import ru.juli.practicum.pageoption.PageAboutRent;
import ru.juli.practicum.pageoption.PageWhoIsScooter;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static ru.juli.practicum.MyConstants.SCOOTER_URL;
@RunWith(Parameterized.class)
public class TestOderScooter {
    WebDriver driver;
    private String firstName;
    private String lastName;
    private String orderAddress;
    private String phoneNumber;
    private String orderDate;

    public TestOderScooter(String firstName, String lastName, String orderAddress, String phoneNumber, String orderDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderAddress = orderAddress;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
    }
    @Parameterized.Parameters
    public static Object[][] getQuestionResponse_01() {
        return new Object[][]{
                {"Юля", "Тестовая", "Москва ул Тестовая 13", "89161234567", "29.03.2023"},
                {"Ива-Иван", "Тестов-Тестов", "11 квартал", "000000000000", "13.01.2023"},
        };
    }
    @Test
    public void OrderTest_01() {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();   // Создание экземпляра ChromeDriver
        driver.get(SCOOTER_URL);
        HomePageScooter objHomePage = new HomePageScooter(driver);  // объект класса домашней страницы
        PageWhoIsScooter objPageWhoIsScooter = new PageWhoIsScooter(driver);  // создать объект класса страницы Для кого
        PageAboutRent objPageAboutRent = new PageAboutRent(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        objHomePage.clickButtonOrderUp(); // Нажать кнопку вверху справа Заказать
        objPageWhoIsScooter.setWhoIsScooter(firstName, lastName, orderAddress, 1, phoneNumber); // Шаг Заполнения формы Для кого самокат
        objPageAboutRent.setAboutRent(orderDate);  // Шаг Заполнения формы ро аренду
        assertEquals("Заказ оформлен", objPageAboutRent.getTextOrderDone()); // проверка текста вопроса

        driver.quit();
    }
@Test
public void OrderTest_02() {
    WebDriver driver = new ChromeDriver();
    WebDriverManager.chromedriver().setup();   // Создание экземпляра ChromeDriver
    driver.get(SCOOTER_URL);
    HomePageScooter objHomePage = new HomePageScooter(driver);  // объект класса домашней страницы
    PageWhoIsScooter objPageWhoIsScooter = new PageWhoIsScooter(driver);  // создать объект класса страницы Для кого
    PageAboutRent objPageAboutRent = new PageAboutRent(driver);
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    objHomePage.clickButtonOrderDown(); // Нажать нижнюю кнопку Заказать
    objPageWhoIsScooter.setWhoIsScooter(firstName, lastName, orderAddress, 1, phoneNumber); // Шаг Заполнения формы Для кого самокат
    objPageAboutRent.setAboutRent(orderDate);  // Шаг Заполнения формы ро аренду
    assertEquals("Заказ оформлен", objPageAboutRent.getTextOrderDone()); // проверка текста вопроса

    driver.quit();
}
}
