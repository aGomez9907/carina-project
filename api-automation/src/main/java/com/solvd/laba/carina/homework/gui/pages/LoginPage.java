package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "button.error-button")
    private ExtendedWebElement errorButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageURL("");
    }

    public void fillLoginData(String username, String password) {
        usernameInput.type(username);
        passwordInput.type(password);
    }

    public InventoryPage clickLoginButton() {
        loginButton.click();
        return new InventoryPage(getDriver());
    }

    public InventoryPageWithProblems clickLoginButton2() {
        loginButton.click();
        return new InventoryPageWithProblems(getDriver());
    }

    public ExtendedWebElement getErrorButton() {
        return errorButton;
    }

}
