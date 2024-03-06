package ru.juli.practicum.pageoption;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

//класс для домашней страницы
public class HomePageScooter {
    private WebDriver driver;

    // Локаторы
    private By faqName = By.className("accordion"); // локатор списка вопросов
    private By buttonCookie = By.className("App_CookieButton__3cvqF"); // локатор кнопки принять куки
    private By listFaq = By.xpath("//div[contains(@id,'accordion__heading')]"); // локатор массива заголовков вопросов
    private By buttonOrderUp = By.className("Button_Button__ra12g"); // локатор верхней кнопки заказать
    // конструктор класса
    public HomePageScooter(WebDriver driver) {
        this.driver = driver; // Инициализировали в нём поле driver
    }
    // методы
    // прокрутить вниз до вопросов
    public void scrollToFaq() {
        WebElement element = driver.findElement(faqName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }
    // нажатие на кнопку приняти куки
    public void clickButtonCookie() {
        driver.findElement(buttonCookie).click();
    }
    public ArrayList<WebElement> findListFaq() {
        return (ArrayList) driver.findElements(listFaq);

    }
    // нажате на стрелочки
    public void clickHeadingFaq(WebElement element) throws InterruptedException {
        element.click();
        Thread.sleep(1000);
    }
    // проверка видимости текста ответа
    public String  isVisible(WebElement element) {
        return element.getAttribute("aria-expanded");
    }
    // нажатие на вернюю кнопку заказать
    public void clickButtonOrderUp() {
        driver.findElement(buttonOrderUp).click();
    }
}



