package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Locators.Locator;
public class LoginPage extends Locator {


    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }

    private String nameField = "login-email";
    private String passwordField = "login-password-input";
    private String loginButton = ".q-primary.q-fluid.q-button-medium.q-button.submit";

    public void Username(String name) {
        SendById(nameField,name);
    }

    public void Password(String password) {
        SendById(passwordField,password);
    }

    public PrimaryPage LoginButton() {
        ClickByCssSelector(loginButton);
        return new PrimaryPage(driver);
    }





}
