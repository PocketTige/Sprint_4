package ru.juli.practicum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.juli.practicum.pageoption.HomePageScooter;
import ru.juli.practicum.pageoption.PageAboutRent;
import ru.juli.practicum.pageoption.PageWhoIsScooter;

import java.time.Duration;

public class TestOderScooter {
    WebDriver driver;

    @Before
    public void setup_01() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Администратор\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void OrderTest_01() {

        driver.get("http://qa-scooter.praktikum-services.ru");
        // объект класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonOrderUp(); // Нажать кнопку вверху справа Заказать
        PageWhoIsScooter objPageWhoIsScooter = new PageWhoIsScooter(driver);  // создать объект класса страницы Для кого

        objPageWhoIsScooter.fillFirstName("Юля"); // заполнить поле имя
        objPageWhoIsScooter.fillLastName("Тестовая"); // заполнить поле фамилия
        objPageWhoIsScooter.fillOrderAddress("Москва ул Тестовая 13"); // заполнить поле адрес
        objPageWhoIsScooter.clickStationUnderground(); // клик в поле станции метро

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select-search__select"))); // ожидание раскрывающегося списка станций метро

        objPageWhoIsScooter.clickListOfStationUnderground(1); // выбор станции из списка
        objPageWhoIsScooter.fillTelephoneNumber("89161234567"); // заполнение поля телефон
        objPageWhoIsScooter.clickButtonNext(); // нажатие далее

        PageAboutRent objPageAboutRent = new PageAboutRent(driver);
        objPageAboutRent.clickOrderPeriod();

        WebDriverWait waitCalendar = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementCalendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-placeholder")));    // ожидание раскрывающегося списка календаря

        objPageAboutRent.chooseOrderPeriod(5); // выбор даты (число)

        objPageAboutRent.clickRentalPeriod();

        WebDriverWait waitPeriodList = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementPeriodList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-placeholder"))); //ожидание раскрывающегося списка срока аренды
        objPageAboutRent.chooseRentalPeriod(); // выбрать значение срока аренды из списка
        objPageAboutRent.clickButtonOrder(); // нажать кнопку Заказать

        WebDriverWait waitOrder = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));     //ожидание открытия окна подтверждения заказа
        objPageAboutRent.clickButtonYes(); // нажать кнопку Да

        WebDriverWait waitOrderFinal = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementOrderFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3"))); //ожидание открытия окна Заказ оформлен

        // Найти элемент с текстом
        WebElement elementFinal = driver.findElement(By.xpath("//div[contains(text(), 'Заказ оформлен')]"));
        // Получить текст из элемента и выполнить проверку
        String actualText = elementFinal.getText();
        Assert.assertTrue("Текст 'Заказ оформлен' не найден на странице", actualText.contains("Заказ оформлен"));
    }

    @After
    public void tearDown_01() {
        driver.quit();
    }

    @Before
    public void setup_02() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Администратор\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void OrderTest_02() {

        driver.get("http://qa-scooter.praktikum-services.ru");
        // объект класса домашней страницы
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.clickButtonOrderUp(); // Нажать кнопку вверху справа Заказать
        PageWhoIsScooter objPageWhoIsScooter = new PageWhoIsScooter(driver);  // создать объект класса страницы Для кого

        objPageWhoIsScooter.fillFirstName("Иван-Иван"); // заполнить поле имя
        objPageWhoIsScooter.fillLastName("Иванов-тестов"); // заполнить поле фамилия
        objPageWhoIsScooter.fillOrderAddress("квартал 1"); // заполнить поле адрес
        objPageWhoIsScooter.clickStationUnderground(); // клик в поле станции метро

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select-search__select"))); // ожидание раскрывающегося списка станций метро

        objPageWhoIsScooter.clickListOfStationUnderground(5); // выбор станции из списка
        objPageWhoIsScooter.fillTelephoneNumber("+79161234567"); // заполнение поля телефон
        objPageWhoIsScooter.clickButtonNext(); // нажатие далее

        PageAboutRent objPageAboutRent = new PageAboutRent(driver);
        objPageAboutRent.clickOrderPeriod();

        WebDriverWait waitCalendar = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementCalendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-placeholder")));   // ожидание раскрывающегося списка календаря

        objPageAboutRent.chooseOrderPeriod(5); // выбор даты (число)

        objPageAboutRent.clickRentalPeriod();

        WebDriverWait waitPeriodList = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementPeriodList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Dropdown-placeholder"))); //ожидание раскрывающегося списка срока аренды
        objPageAboutRent.chooseRentalPeriod(); // выбрать значение срока аренды из списка
        objPageAboutRent.clickButtonOrder(); // нажать кнопку Заказать

        WebDriverWait waitOrder = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));     //ожидание открытия окна подтверждения заказа
        objPageAboutRent.clickButtonYes(); // нажать кнопку Да

        WebDriverWait waitOrderFinal = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementOrderFinal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3"))); //ожидание открытия окна Заказ оформлен
        // Найти элемент с текстом

        WebElement elementFinal = driver.findElement(By.xpath("//div[contains(text(), 'Заказ оформлен')]"));
        // Получить текст из элемента и выполнить проверку
        String actualText = elementFinal.getText();
        Assert.assertTrue("Текст 'Заказ оформлен' не найден на странице", actualText.contains("Заказ оформлен"));
    }


    @After
    public void tearDown_02() {
        driver.quit();
    }
}

