package ru.juli.practicum.pageoption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// класс страницы Для кого самокат
public class PageWhoIsScooter {
    WebDriver driver;
    private int index;
    // Локаторы
    private By fieldFirstName = By.cssSelector("input[placeholder='* Имя']"); // локатор поля Имя
    private By fieldLastName = By.cssSelector("input[placeholder='* Фамилия']"); // локатор поля Фамилия
    private By fieldOrderAddress = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']"); // локатор поля Адресс
    private By fieldStationUnderground = By.cssSelector("input[placeholder='* Станция метро']"); // локатор поля Станция метро
    private By listOfStationUnderground = By.xpath("//li[contains(@data-value,'" + index + "')]"); // локатор списка Станция метро
    private By fieldTelephoneNumber = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']"); // локатор поля Телефон
    private By buttonNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"); // локатор кнопки Далее

    // конструктор класса page object
    public PageWhoIsScooter(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }

    // методы
    public void fillFirstName(String name) {
        driver.findElement(fieldFirstName).sendKeys(name);
    }
    // заполняем поле имя

    public void fillLastName(String lastName) {
        driver.findElement(fieldLastName).sendKeys(lastName);
    }
    // заполняем поле Фамилия

    public void fillOrderAddress(String adress) {
        driver.findElement(fieldOrderAddress).sendKeys(adress);
    }
    public void clickStationUnderground() {
        driver.findElement(fieldStationUnderground).click();
    }

    // выбор станции метро
    //1 клик по полю
    public void clickListOfStationUnderground(int index) {
        this.index = index;
        driver.findElement(listOfStationUnderground).click();
    }
    //2 выбор варианта из списка

    public void fillTelephoneNumber(String phoneNumber) {
        driver.findElement(fieldTelephoneNumber).sendKeys(phoneNumber);
    }
    // заполнение телефона
    public void clickButtonNext() {
        driver.findElement(buttonNext).click(); // метод поиска и нажатия на кнопку Далее
    }
}
