package Pages;

import Locators.Locator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketPage extends Locator {

    WebDriver driver;
    WebDriverWait wait;

    public BasketPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        wait = new WebDriverWait(driver, 30);
    }
    private String deleteProduct = "//a[@title='Sil']";
    private String productAdd ="//select[@class='amount']";
    private String productUpSelect ="//select[@class='amount']//child::option[@value='2']";
    private String productCount = "//select[@class='amount']//child::option[@value='2']";
    String expectedProductCount = "2";
    private String basketStatus = "//div[@class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']";
    String expectedbasketStatus = "Sepetinizde ürün bulunmamaktadır.";
    private String basketTotalPrice = "//p[@class='new-price']";

    public void assertPrice() {

        String totalPrice = GetTextByXpath(basketTotalPrice);
        Assert.assertEquals("4.199,00 TL", totalPrice);
    }

    public void assertProductCount() {

        String actualProductCounts=GetAttributeByXpath(productCount,"value");
        Assert.assertEquals(expectedProductCount, actualProductCounts);
    }

    public void assertBasketSituation() {

        String actualBasketStatus = GetTextByXpath(basketStatus);
        Assert.assertTrue(expectedbasketStatus.contains(actualBasketStatus));
    }

    public void clickProductAdd() {

        ClickByXpath(productAdd);
        ClickByXpath(productUpSelect);
    }

    public void clickDeleteProduct() {

       ClickByXpath(deleteProduct);
    }





}
