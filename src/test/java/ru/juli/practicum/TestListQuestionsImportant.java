package ru.juli.practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.juli.practicum.pageoption.HomePageScooter;

import static org.junit.Assert.assertEquals;
import static ru.juli.practicum.MyConstants.*;

@RunWith(Parameterized.class)
public class TestListQuestionsImportant {
    WebDriver driver;
    private final String question;
    private final String response;
    private final boolean isMatches;
    private final String expectedQuestion;
    private final String expectedResponse;

    public TestListQuestionsImportant(String question, String expectedQuestion, String response, String expectedResponse, boolean isMatches) {
        this.question = question; //  вопрос
        this.expectedQuestion = expectedQuestion; // ожидаемый вопрос
        this.response = response; //  ответ
        this.expectedResponse = expectedResponse; // ожидаемый ответ
        this.isMatches = isMatches;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionResponse_01() {
        return new Object[][]{
                {"accordion__heading-0", "Сколько это стоит? И как оплатить?", "accordion__panel-0", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true},
                {"accordion__heading-1", "Хочу сразу несколько самокатов! Так можно?", "accordion__panel-1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {"accordion__heading-2", "Как рассчитывается время аренды?", "accordion__panel-2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {"accordion__heading-3", "Можно ли заказать самокат прямо на сегодня?", "accordion__panel-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {"accordion__heading-4", "Можно ли продлить заказ или вернуть самокат раньше?", "accordion__panel-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {"accordion__heading-5", "Вы привозите зарядку вместе с самокатом?", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                {"accordion__heading-6", "Можно ли отменить заказ?", "accordion__panel-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {"accordion__heading-7", "Я жизу за МКАДом, привезёте?", "accordion__panel-7", "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
        };
    }

    @Test
    public void setQuestionTest_01() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();   // Создание экземпляра ChromeDriver
        driver.get(SCOOTER_URL);
        HomePageScooter objHomePage = new HomePageScooter(driver);  // объект класса домашней страницы
        objHomePage.clickButtonCookie(); // нажимаем принять куки
        objHomePage.scrollToFaq();       //найти заголовок списка и прокрутить до списка
        objHomePage.clickQuestion(question); // найти и кликнуть по кнопке вопроса

        assertEquals(expectedQuestion, objHomePage.getTextQuestion(question)); // проверка текста вопроса
        assertEquals(expectedResponse, objHomePage.getTextResponse(response)); // ожидание видимости ответа и получить его текст

        driver.quit();
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionResponse_02() {
        return new Object[][]{
                {"accordion__heading-0", "Сколько это стоит? И как оплатить?", "accordion__panel-0", "Сутки — 1500 рублей. Оплата курьеру — наличными или картой.", false},
                {"accordion__heading-1", "Хочу сразу несколько самокатов! Так можно?", "accordion__panel-1", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
                {"accordion__heading-2", "Как рассчитывается время аренды?", "accordion__panel-2", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
                {"accordion__heading-3", "Можно ли заказать самокат прямо на сегодня?", "accordion__panel-3", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
                {"accordion__heading-4", "Можно ли продлить заказ или вернуть самокат раньше?", "accordion__panel-4", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
                {"accordion__heading-5", "Вы привозите зарядку вместе с самокатом?", "accordion__panel-5", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
                {"accordion__heading-6", "Можно ли отменить заказ?", "accordion__panel-6", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
                {"accordion__heading-7", "Я жизу за МКАДом, привезёте?", "accordion__panel-7", "не повезло", false},
        };
    }
@Test
public void setQuestionTest_02() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    WebDriverManager.chromedriver().setup();   // Создание экземпляра ChromeDriver
    driver.get(SCOOTER_URL);
    HomePageScooter objHomePage = new HomePageScooter(driver);  // объект класса домашней страницы
    objHomePage.clickButtonCookie(); // нажимаем принять куки
    objHomePage.scrollToFaq();       //найти заголовок списка и прокрутить до списка
    objHomePage.clickQuestion(question); // найти и кликнуть по кнопке вопроса

    assertEquals(expectedQuestion, objHomePage.getTextQuestion(question)); // проверка текста вопроса
    assertEquals(expectedResponse, objHomePage.getTextResponse(response)); // ожидание видимости ответа и получить его текст

    driver.quit();
}
}
