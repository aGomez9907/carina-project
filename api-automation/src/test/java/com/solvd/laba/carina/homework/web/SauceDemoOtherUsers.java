package com.solvd.laba.carina.homework.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.homework.gui.pages.InventoryPageWithProblems;
import com.solvd.laba.carina.homework.gui.pages.LoginPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.annotations.Test;

public class SauceDemoOtherUsers implements IAbstractTest {
    //test login with locked_out_user
    @Test()
    @MethodOwner(owner = "agomez")
    public void lockedLoginTest() {
        LoginPage login = new LoginPage(getDriver());
        login.open();
        login.assertPageOpened();
        login.fillLoginData(R.TESTDATA.get("sauce_demo_username_locked"), R.TESTDATA.get("sauce_demo_password"));
        login.clickLoginButton();
        login.assertElementPresent(login.getErrorButton());
    }

    //test login with problem_user using opening strategy by url and element
    @Test()
    @MethodOwner(owner = "agomez")
    public void problemsLoginTest() {
        LoginPage login = new LoginPage(getDriver());
        login.open();
        login.assertPageOpened();
        login.fillLoginData(R.TESTDATA.get("sauce_demo_username_problems"), R.TESTDATA.get("sauce_demo_password"));
        InventoryPageWithProblems inventoryPageWithProblems = login.clickLoginButton2();
        inventoryPageWithProblems.assertPageOpened(2);

    }
}
