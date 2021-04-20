package Pages;

import Locators.Locator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrimaryPage extends Locator {
    private WebDriver driver;
    private WebDriverWait wait;

    public PrimaryPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        wait = new WebDriverWait(driver, 30);
    }

    private String searchFıeld = "search-box";
    private String findButton = "search-icon";
    private String accountNameField = "user-name";
    String expectedAccountName = "Hesabım\nqquestionanswer";

    public void assertAccountName() {

        String actualAccountName=GetTextByClassName(accountNameField);
        Assert.assertEquals(expectedAccountName, actualAccountName);
    }

    public void SearchArea(String search) {

        SendByClassName(searchFıeld,search);
    }

    public SelectPage clickFindButton() {
        ClickByClassName(findButton);
        return new SelectPage(driver);
    }

}
