package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractPage {

    @FindBy(id = "back-to-products")
    private ExtendedWebElement backHome;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setPageURL("checkout-complete.html");
    }

    public InventoryPage clickBackHome() {
        backHome.click();
        return new InventoryPage(getDriver());
    }
}
