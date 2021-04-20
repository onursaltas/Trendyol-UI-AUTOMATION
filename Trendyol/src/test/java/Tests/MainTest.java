package Tests;

import Users.AccountInformation;
import Users.UserPool;
import org.junit.Test;
import Pages.*;
import Data.*;


public class MainTest extends InitialTest {

    @Test
    public void Trendyol_Project_Test_Scenario_1(){


        LoginPage loginPage = homePage.clickLogin();
        AccountInformation accountInformation = UserPool.getUserFirst();
        loginPage.Username(accountInformation.getEmail());
        loginPage.Password(accountInformation.getPassword());

        PrimaryPage primaryPage =loginPage.LoginButton();
        primaryPage.assertAccountName();
        primaryPage.SearchArea("KİTAP");

        SelectPage selectpage = primaryPage.clickFindButton();
        selectpage.clickSecondPageButton();
        selectpage.assertPageNumber();

        ProductPage productPage = selectpage.selectProduct();
        productPage.clickAddBasket();

        BasketPage basketPage = productPage.clickBasketPage();
        basketPage.assertPrice();
        basketPage.clickProductAdd();
        basketPage.assertProductCount();
        basketPage.clickDeleteProduct();
        basketPage.assertBasketSituation();

    }


}
