package Pages;

import Locators.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Locator  {

    private WebDriverWait wait;
    private WebDriver driver;

    private String login=".account-user";
    String loginUrl = "https://www.trendyol.com/giris?cb=https%3A%2F%2Fwww.trendyol.com%2F";

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    public LoginPage clickLogin() {

        driver.get(loginUrl);
        return new LoginPage(driver);
    }

}
