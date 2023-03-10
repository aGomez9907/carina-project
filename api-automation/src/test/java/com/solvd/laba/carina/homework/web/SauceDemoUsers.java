package com.solvd.laba.carina.homework.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.homework.gui.pages.InventoryPage;
import com.solvd.laba.carina.homework.gui.pages.LoginPage;
import com.solvd.laba.carina.homework.services.LoginService;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoUsers implements IAbstractTest {


    @Test()
    @MethodOwner(owner = "agomez")
    public void standardLoginTest() {
        LoginService ls = new LoginService(getDriver());
        InventoryPage inventoryPage = ls.login(R.TESTDATA.get("sauce_demo_username_standard"), R.TESTDATA.get("sauce_demo_password"));
        inventoryPage.assertPageOpened();
    }


    //test login with locked_out_user
    @Test()
    @MethodOwner(owner = "agomez")
    public void lockedLoginTest() {
        LoginService ls = new LoginService(getDriver());
        LoginPage login = ls.loginWithError(R.TESTDATA.get("sauce_demo_username_locked"), R.TESTDATA.get("sauce_demo_password"));
        Assert.assertTrue(login.isError());
    }

    //test login with problem_user using opening strategy by url and element
    @Test()
    @MethodOwner(owner = "agomez")
    public void problemsLoginTest() {
        LoginService ls = new LoginService(getDriver());
        InventoryPage inventoryPageWithProblems = ls.login(R.TESTDATA.get("sauce_demo_username_problems"), R.TESTDATA.get("sauce_demo_password"));
        Assert.assertTrue(inventoryPageWithProblems.isProblematic());
    }
}
