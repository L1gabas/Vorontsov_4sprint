package ru.yandex.praktikum.scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;
import ru.yandex.praktikum.page.RentPage;

public class OrderButton {
    private WebDriver driver;

    @Before
    public void setup() {
        //WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    @Test
    public void createOrderHeaderButton() { //оформление заказа через кнопку заказать вверху страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOrderHeaderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.enterProfile("Иван", "Иванов", "Дубки, 1", "Сокольники", "12345678901");
        orderPage.clickNextButton();
        RentPage orderRentPage = new RentPage(driver);
        orderRentPage.enterRentInfo("27.04.2024");
        orderRentPage.clickOrderButton();
        orderRentPage.clickConfirmOrderButton();
        orderRentPage.checkOrderIsProcessed();
    }

    @Test
    public void createOrderFinishButton() { //оформление заказа через кнопку заказать внизу страницы
        MainPage mainPage = new MainPage(driver);
        mainPage.confirmCookies();
        mainPage.clickOrderFinishButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.enterProfile("Вован", "Вованов", "Дубки, 13", "Динамо", "12345678902");
        orderPage.clickNextButton();
        RentPage orderRentPage = new RentPage(driver);
        orderRentPage.enterRentInfo("18.07.2024");
        orderRentPage.clickOrderButton();
        orderRentPage.clickConfirmOrderButton();
        orderRentPage.checkOrderIsProcessed();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}