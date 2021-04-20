package Tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.*;
import Locators.*;
public class InitialTest {

    private static WebDriver driver;
    public static HomePage homePage;
    private static By advertisement=By.xpath("//img[@src='https://cdn.dsmcdn.com/web/production/gender-popup-male.png']");

    @BeforeClass
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "./src/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
        Assert.assertEquals(expectedTitle, actualTitle);
        //driver.findElement(advertisement);
        homePage = new HomePage(driver);


    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }


}
