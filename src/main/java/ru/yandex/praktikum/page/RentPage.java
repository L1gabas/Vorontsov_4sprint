package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class RentPage {

    private final WebDriver driver;


    //Локаторы
    //Локатор Когда привезти самокат
    private By dateInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Локатор поля ввода Срок аренды
    private By rentInputLocator = By.xpath("//div[text()='* Срок аренды']");
    //Локатор срока аренды Сутки
    private By oneDayLocator= By.xpath("//div[text()='сутки']");
    //Локатор кнопки Заказать
    private By rentBottomButtonLocator = By.xpath("//div[contains(@class, 'Order')]//button[text()='Заказать']");
    //Локатор кнопки Да
    private By orderHeaderButtonLocator = By.xpath("//button[text()='Да']");
    //Локатор всплывающего окна Заказ оформлен
    private By orderIsProcessedLocator= By.xpath("//button[text()='Посмотреть статус']");

    //Конструктор
    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    public void enterDeliveryDate(String deliveryDate) {
        WebElement inputDate = driver.findElement(dateInputLocator);
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(inputDate));
        inputDate.sendKeys(deliveryDate, Keys.ENTER);
    }
    public void enterRentalPeriod() {
        driver.findElement(rentInputLocator).click();
        driver.findElement(oneDayLocator).click();
    }
    public void enterRentInfo(String deliveryDate) {
        enterDeliveryDate(deliveryDate);
        enterRentalPeriod();
    }
    public void clickOrderButton() {
        driver.findElement(rentBottomButtonLocator).click();
    }
    public void clickConfirmOrderButton() {
        driver.findElement(orderHeaderButtonLocator).click();
    }

    public void checkOrderIsProcessed() {
        WebElement checkStatus = driver.findElement(orderIsProcessedLocator);
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(checkStatus));
    }
}