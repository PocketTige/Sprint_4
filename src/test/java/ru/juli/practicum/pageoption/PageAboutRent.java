package ru.juli.practicum.pageoption;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.Keys.ENTER;

// Класс страницы Про аренду
public class PageAboutRent {
    private WebDriver driver;
    // Локаторы
    private By fieldOrderDate = By.cssSelector("input[placeholder='* Когда привезти самокат']"); // поле когда привезти самокат
    // private By fieldCalendar = By.xpath("//div[contains(@class,'react-datepicker__day--0"+number+"')]");
    private By fieldRentalPeriod = By.className("Dropdown-placeholder"); // локатор поля срок аренды  Список ?
    private By fieldRentalPeriodList = By.className("Dropdown-placeholder"); // локатор списка срока аренды
    private By fieldRentalPeriodListValue = By.xpath("//div[@class='Dropdown-option' and text()='трое суток']"); // локатор значения из списка срока аренды
    private By buttonOrder = By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Заказать']"); // локатор кнопки Заказать
    private By buttonOrderYes = By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']"); // локатор кнопки Да
    private By orderDone = By.xpath("//div[contains(text(), 'Заказ оформлен')]"); // локатор заголовка заказ Оформлен

    // конструктор класса page object
    public PageAboutRent(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }

    // методы
    //кликнуть в поле календарь
    //заполнить поле в календаре
    public void clickOrderDate(String orderDate) {
        driver.findElement(fieldOrderDate).click();
        driver.findElement(fieldOrderDate).sendKeys(orderDate);
        driver.findElement(fieldOrderDate).sendKeys(Keys.ENTER); // ожидание раскрывающегося списка календаря
    }

    // срок аренды
    public void chooseOrderPeriod() {
        driver.findElement(fieldRentalPeriod).click();
        driver.findElement(fieldRentalPeriodListValue).click();
    }

    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click(); // мотод поиска и нажатия на кнопку Заказать
    }

    public void clickButtonYes() {
        driver.findElement(buttonOrderYes).click(); // мотод поиска и нажатия на кнопку Да
    }

    // шаг заполнения формы Про аренду
    public void setAboutRent(String orderDate) {
        clickOrderDate(orderDate);
        chooseOrderPeriod();
        clickButtonOrder();
        clickButtonYes();
    }
    // Получить текст из элемента Заказ оформлен
    public String getTextOrderDone() {
        String actualTextOrderDone = driver.findElement(orderDone).getText();
        return actualTextOrderDone;
    }
}