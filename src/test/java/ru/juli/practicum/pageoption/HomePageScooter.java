package ru.juli.practicum.pageoption;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//класс для домашней страницы
public class HomePageScooter {
    private WebDriver driver;

    // Локаторы
    private By faqName = By.className("accordion"); // локатор Заголовка списка вопросов
    private By buttonCookie = By.className("App_CookieButton__3cvqF"); // локатор кнопки принять куки
    private By question = By.xpath(".//div[contains(@)id,'accordion__heading-')]"); // локатор стрелочки-вопроса всех  id="accordion__heading-0"
    private By buttonOrderUp = By.className("Button_Button__ra12g"); // локатор верхней кнопки заказать
    private By buttonOrderDown = By.className("Button_Button__ra12g Button_UltraBig__UU3Lp"); // локатор нижней кнопки заказать

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

    // нашли стрелку и нажать на вопрос
    public void clickQuestion(String question_0) {
        driver.findElement(By.id(question_0)).click();
    }

    // получение текста вопроса
    public String getTextQuestion(String question) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id(question))); // ожидаем когда элемент будет виден
        String actualQuestion = driver.findElement(By.id(question)).getText();
        return actualQuestion;
    }
        // + ожидание получить текст из ответа
        public String getTextResponse(String response) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id(response))); // ожидаем когда элемент с ответом будет виден
        String actualResponse = driver.findElement(By.id(response)).getText();
        return actualResponse;
    }
    // на верхнюю кнопку заказать
    public void clickButtonOrderUp() {
        driver.findElement(buttonOrderUp).click();
    }

    // прокрутить вниз на нижнюю кнопку заказать
    public void clickButtonOrderDown() {
        WebElement element = driver.findElement(buttonOrderDown);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(buttonOrderDown).click();
    }
}



