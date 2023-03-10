package com.solvd.laba.carina.homework.services;

import com.solvd.laba.carina.homework.gui.pages.InventoryPage;
import com.solvd.laba.carina.homework.gui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService {
    private final WebDriver driver;

    public LoginService(WebDriver driver) {
        this.driver = driver;
    }


    public InventoryPage login(String username, String password) {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.assertPageOpened();
        login.fillLoginData(username, password);
        return login.clickLoginButton();
    }

    public LoginPage loginWithError(String username, String password) {
        LoginPage login = new LoginPage(driver);
        login.open();
        login.assertPageOpened();
        login.fillLoginData(username, password);
        login.clickLoginButton();
        return login;
    }
}
