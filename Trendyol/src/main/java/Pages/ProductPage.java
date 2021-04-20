package Pages;

import Locators.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends Locator {

    WebDriver driver;
    WebDriverWait wait;
    public static String productPrice;



    public ProductPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        wait = new WebDriverWait(driver, 30);
    }

    private By addBasket = By.id("add-to-basket");
    private String productPriceId = "sp-price-highPrice";
    private String basketXpath = "//a[@class='header-cart-hidden-link']";
    private String basketLinkPath = "dIB";

    public void clickAddBasket() {

        wait.until(ExpectedConditions.presenceOfElementLocated(addBasket));
        WebElement webElement = driver.findElement(addBasket);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);

        productPrice = GetTextByXpath(productPriceId);
    }

    public BasketPage clickBasketPage() {

        ClickByXpath(basketLinkPath);
        return new BasketPage(driver);


    }






}
