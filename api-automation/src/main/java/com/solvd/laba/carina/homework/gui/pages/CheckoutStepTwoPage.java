package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends AbstractPage {

    @FindBy(id = "finish")
    private ExtendedWebElement finishButton;
    @FindBy(id = "cancel")
    private ExtendedWebElement cancelButton;

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        setPageURL("checkout-step-two.html");
    }

    public CheckoutStepOnePage clickCancelButton() {
        cancelButton.click();
        return new CheckoutStepOnePage(getDriver());
    }

    public CheckoutCompletePage clickFinishButton() {
        finishButton.click();
        return new CheckoutCompletePage(getDriver());
    }
}
