package ru.juli.practicum.pageoption;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс страницы Про аренду
public class PageAboutRent {
    private WebDriver driver;
    // Локаторы
    private By fieldOrderDate = By.cssSelector("input[placeholder='* Когда привезти самокат']"); // поле когда привезти самокат
    //private By fieldCalendar = By.xpath("//div[contains(@class,'react-datepicker__day--0"+number+"')]");

    private By fieldRentalPeriod = By.className("Dropdown-placeholder"); // локатор поля срок аренды  Список ?
    //private By fieldRentalPeriodList = By.className("Dropdown-placeholder"); // локатор списка срока аренды
    private By fieldRentalPeriodListValue = By.xpath("//div[@class='Dropdown-option' and text()='трое суток']"); // локатор значения из списка срока аренды
    private By buttonOrder = By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Заказать']"); // локатор кнопки Заказать
    private By buttonOrderYes = By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']"); // локатор кнопки Да

    // конструктор класса page object
    public PageAboutRent(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }
    // методы

    public void clickOrderPeriod() {
        driver.findElement(fieldOrderDate).click();
    } //кликнуть в поле календарь


    public String chooseOrderPeriodNew(int number) {
        if (number < 10) {
            String s = "0" + number;
            return s;
        }
            return String.valueOf(number);
    }
    public void chooseOrderPeriod(int num) {
            String number =  chooseOrderPeriodNew(num);
        driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day--0"+number+"')]")).click();
    } //выбрать значение в календаре


    public void clickRentalPeriod() {
        driver.findElement(fieldRentalPeriod).click();
    } //нажать в поле срок аренды

    public void chooseRentalPeriod() {
        driver.findElement(fieldRentalPeriodListValue).click();
    } // выбрать значение срок аренды

    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click(); // мотод поиска и нажатия на кнопку Заказать
    }
    public void clickButtonYes() {
        driver.findElement(buttonOrderYes).click(); // мотод поиска и нажатия на кнопку Да
    }
}