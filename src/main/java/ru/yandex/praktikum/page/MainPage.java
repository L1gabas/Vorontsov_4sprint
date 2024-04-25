package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.time.Duration.ofSeconds;

public class MainPage {

    private final WebDriver driver;

    //Локаторы верхней кнопки
    private By orderHeaderButtonLocator = By.xpath("//div[contains(@class, 'Header')]//button[text()='Заказать']");
    //Локаторы нижней кнопки
    private By orderFinishButtonLocator = By.xpath("//div[contains(@class, 'FinishButton')]//button[text()='Заказать']");
    //Локатор кнопки принятия куки
    private By confirmCookiesLocator= By.id("rcc-confirm-button");
    //Локатор вопроса
    private final String questionLocator = "accordion__heading-%s";
    //Локатор ответа
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    //Конструктор.
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    public void clickOrderHeaderButton() {
        driver.findElement(orderHeaderButtonLocator).click();
    }

    public void clickOrderFinishButton() {
        driver.findElement(orderFinishButtonLocator).click();
    }

    public void confirmCookies() {
        driver.findElement(confirmCookiesLocator).click();
    }

    public void openQuestion(int index) {
        WebElement element = driver.findElement(By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = driver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        new WebDriverWait(driver, ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return element.isDisplayed();
    }
}