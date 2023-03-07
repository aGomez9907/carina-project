package com.solvd.laba.carina.homework.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.homework.gui.components.FooterMenu;
import com.solvd.laba.carina.homework.gui.components.Header;
import com.solvd.laba.carina.homework.gui.dataprovider.CheckoutProvider;
import com.solvd.laba.carina.homework.gui.pages.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoWithStandardUser implements IAbstractTest {

    //test login with standard_user
    @Test()
    @MethodOwner(owner = "agomez")
    @BeforeMethod
    public void standardLoginTest() {
        LoginPage login = new LoginPage(getDriver());
        login.open();
        login.assertPageOpened();
        login.fillLoginData(R.TESTDATA.get("sauce_demo_username_standard"), R.TESTDATA.get("sauce_demo_password"));
        InventoryPage inventoryPage = login.clickLoginButton();
        inventoryPage.assertPageOpened();
    }


    @Test()
    @MethodOwner(owner = "agomez")
    public void testItems() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        InventoryItem inventoryItem = inventoryPage.clickBackpack();
        inventoryItem.assertPageOpened(3);
    }

    @Test(dataProvider = "CheckoutData", dataProviderClass = CheckoutProvider.class)
    @MethodOwner(owner = "agomez")
    public void createOrderTest(String firstName, String lastName, String zipCode) {
        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.addBackpack();

        Header header = inventoryPage.getHeader();

        Cart cart = header.clickCart();
        cart.assertPageOpened();

        CheckoutStepOne checkoutStepOne = cart.clickCheckoutButton();
        checkoutStepOne.assertPageOpened();

        checkoutStepOne.fillClientInfo(firstName, lastName, zipCode);
        CheckoutStepTwo checkoutStepTwo = checkoutStepOne.clickContinueButton();
        checkoutStepTwo.assertPageOpened();

        CheckoutComplete checkoutComplete = checkoutStepTwo.clickFinishButton();
        checkoutComplete.assertPageOpened();
        checkoutComplete.clickBackHome();

    }


    @Test()
    @MethodOwner(owner = "agomez")
    public void testSorting() {
        InventoryPage inventoryPage = new InventoryPage(getDriver());

        Header header = inventoryPage.getHeader();
        header.clickSort();
        header.sortLoToHi();
        List<Double> prices = inventoryPage.getItemPrices();
        for (int i = 0; i < prices.size() - 2; i++) {
            Assert.assertTrue(prices.get(i) <= prices.get(i + 1));
        }
    }


    @Test()
    @MethodOwner(owner = "agomez")
    public void testFooterLinks() {
        WebDriver driver = getDriver();
        InventoryPage inventoryPage = new InventoryPage(getDriver());

        FooterMenu footer = inventoryPage.getFooter();
        footer.clickFacebook();
        ArrayList<String> handlers = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handlers.get(1));
        Assert.assertEquals(getDriver().getCurrentUrl(), R.TESTDATA.get("facebook_url"));
        driver.close();

    }
}
