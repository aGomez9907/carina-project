package com.solvd.laba.carina.homework.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.laba.carina.homework.gui.pages.Cart;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement menuButton;
    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement shoppingCart;

    @FindBy(className = "product_sort_container")
    private ExtendedWebElement sortButton;

    @FindBy(xpath = "//option[@value='az']")
    private ExtendedWebElement filterOptionAZ;
    @FindBy(xpath = "//option[@value='za']")
    private ExtendedWebElement filterOptionZA;
    @FindBy(xpath = "//option[@value='lohi']")
    private ExtendedWebElement filterOptionLowestToHighest;
    @FindBy(xpath = "//option[@value='hilo']")
    private ExtendedWebElement filterOptionHighestToLowest;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public Cart clickCart() {
        shoppingCart.click();
        return new Cart(getDriver());
    }

    public void clickSort() {
        sortButton.click();
    }

    public void sortAToZ() {
        filterOptionAZ.click();
    }

    public void sortZToA() {
        filterOptionZA.click();
    }

    public void sortLoToHi() {
        filterOptionLowestToHighest.click();
    }

    public void sortHiToLo() {
        filterOptionHighestToLowest.click();
    }
}
