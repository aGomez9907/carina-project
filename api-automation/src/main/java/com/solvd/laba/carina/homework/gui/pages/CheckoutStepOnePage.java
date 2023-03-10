package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends AbstractPage {

    @FindBy(id = "first-name")
    private ExtendedWebElement firstName;
    @FindBy(id = "last-name")
    private ExtendedWebElement lastName;
    @FindBy(id = "postal-code")
    private ExtendedWebElement postalCode;
    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;
    @FindBy(id = "cancel")
    private ExtendedWebElement cancelButton;

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        setPageURL("checkout-step-one.html");
    }

    public void fillClientInfo(String firstName, String lastName, String postalCode) {
        this.firstName.type(firstName);
        this.lastName.type(lastName);
        this.postalCode.type(postalCode);

    }

    public CheckoutStepTwoPage clickContinueButton() {
        continueButton.click();
        return new CheckoutStepTwoPage(getDriver());
    }

    public CartPage clickCancelButton() {
        cancelButton.click();
        return new CartPage(getDriver());
    }

}
