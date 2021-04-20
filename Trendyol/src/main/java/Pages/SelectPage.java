package Pages;

import Locators.Locator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectPage extends Locator {

    private WebDriver driver;
    private WebDriverWait wait;

    public SelectPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        wait = new WebDriverWait(driver, 30);
    }

    private By productsList = By.xpath("//ul[@class='catalog-view clearfix products-container']");
    private String secondPage = "//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a";
    private String actualPageNumberXpath = "//a[@class='current']";
    private String expectedPageNumber = "2";

    public void assertPageNumber() {

        String actualPageNumber=GetTextByXpath(actualPageNumberXpath);
        Assert.assertEquals(expectedPageNumber, actualPageNumber);
    }

    public void clickSecondPageButton() {
        ClickByXpath(secondPage);
    }

    public ProductPage selectProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(productsList));
        List<WebElement> productList = driver.findElements(productsList);
        productList.get(0).click();
        return new ProductPage(driver);

    }

}
