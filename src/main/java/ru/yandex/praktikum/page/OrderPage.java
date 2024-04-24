package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {

    private final WebDriver driver;

    //Локатор кнопки Далее
    private By nextButtonLocator = By.xpath("//div[contains(@class, 'NextButton')]//button[text()='Далее']");
    //Локатор Имя
    private By nameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    //Локатор Фамилия
    private By lastNameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    //Локатор Адрес: куда привезти самокат
    private By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор Телефон
    private By phoneInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор Станция метро
    private By inputSubwayStationLocator = By.xpath("//div/input[@placeholder='* Станция метро']");
    //Локатор метро из списка
    private final String subwayStationLocator = "//div[text()='%s']";

    //Конструктор.
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    public void enterName(String name) {
        driver.findElement(nameInputLocator).sendKeys(name);
    }
    public void enterLastname(String surname) {driver.findElement(lastNameInputLocator).sendKeys(surname);
    }
    public void enterAddress(String address) {
        driver.findElement(addressInputLocator).sendKeys(address);
    }
    public void enterSubwayStation(String subwayTitle) {
        driver.findElement(inputSubwayStationLocator).click();
        WebElement stationMenu = driver.findElement(By.xpath(String.format(subwayStationLocator, subwayTitle)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", stationMenu);
        stationMenu.click();
    }
    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneInputLocator).sendKeys(phoneNumber);
    }
    public void clickNextButton() {
        driver.findElement(nextButtonLocator).click();
    }

    public void enterProfile(String name, String lastName, String address, String subwayTitle, String phoneNumber) {
        enterName(name);
        enterLastname(lastName);
        enterAddress(address);
        enterSubwayStation(subwayTitle);
        enterPhoneNumber(phoneNumber);
    }
}
