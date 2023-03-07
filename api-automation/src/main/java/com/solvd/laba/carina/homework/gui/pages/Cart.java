package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Cart extends AbstractPage {

    @FindBy(id = "checkout")
    private ExtendedWebElement checkoutButton;
    @FindBy(id = "continue-shopping")
    private ExtendedWebElement continueShoppingButton;

    public Cart(WebDriver driver) {
        super(driver);
        setPageURL("cart.html");
    }

    public InventoryPage clickContinueShopping() {
        continueShoppingButton.click();
        return new InventoryPage(getDriver());
    }

    public CheckoutStepOne clickCheckoutButton() {
        checkoutButton.click();
        return new CheckoutStepOne(getDriver());
    }
}
