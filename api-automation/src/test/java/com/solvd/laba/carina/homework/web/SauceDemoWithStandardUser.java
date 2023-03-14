package com.solvd.laba.carina.homework.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.homework.gui.components.FooterMenu;
import com.solvd.laba.carina.homework.gui.components.Header;
import com.solvd.laba.carina.homework.gui.dataprovider.CheckoutProvider;
import com.solvd.laba.carina.homework.gui.pages.*;
import com.solvd.laba.carina.homework.services.LoginService;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoWithStandardUser implements IAbstractTest {


    @BeforeMethod
    public void login() {
        LoginService ls = new LoginService(getDriver());
        InventoryPage inventoryPage = ls.login(R.TESTDATA.get("sauce_demo_username_standard"), R.TESTDATA.get("sauce_demo_password"));
        inventoryPage.assertPageOpened();
    }


    @Test()
    @MethodOwner(owner = "agomez")
    public void testItems() {

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        InventoryItemPage inventoryItemPage = inventoryPage.selectItemByName("Sauce Labs Onesie");
        inventoryItemPage.assertPageOpened();


        Assert.assertTrue(inventoryItemPage.assertInventoryItem("Sauce Labs Onesie"), "Incorrect item page");
    }

    @Test(dataProvider = "CheckoutData", dataProviderClass = CheckoutProvider.class)
    @MethodOwner(owner = "agomez")
    public void createOrderTest(String firstName, String lastName, String zipCode) {
        WebDriver driver = getDriver();

        InventoryPage inventoryPage = new InventoryPage(getDriver());

        InventoryItemPage inventoryItemPage = inventoryPage.selectItemByName("Sauce Labs Onesie");
        inventoryItemPage.assertPageOpened();
        inventoryItemPage.clickAddToCart();
        driver.navigate().back();

        Header header = inventoryPage.getHeader();

        CartPage cartPage = header.clickCart();
        cartPage.assertPageOpened();

        CheckoutStepOnePage checkoutStepOnePage = cartPage.clickCheckoutButton();
        checkoutStepOnePage.assertPageOpened();

        checkoutStepOnePage.fillClientInfo(firstName, lastName, zipCode);
        CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.clickContinueButton();
        checkoutStepTwoPage.assertPageOpened();

        CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.clickFinishButton();
        checkoutCompletePage.assertPageOpened();


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
            Assert.assertTrue(prices.get(i) <= prices.get(i + 1), "Items sorting failed.");
        }
    }


    @Test()
    @MethodOwner(owner = "agomez")
    public void testFooterLinks() {
        WebDriver driver = getDriver();
        InventoryPage inventoryPage = new InventoryPage(getDriver());

        FooterMenu footer = inventoryPage.getFooter();
        FacebookPage fb = footer.clickFacebook();
        ArrayList<String> handlers = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handlers.get(1));
        fb.assertPageOpened();

    }
}
