package com.solvd.laba.carina.homework.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.laba.carina.homework.gui.pages.InventoryItem;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Item extends AbstractUIObject {
    @FindBy(className = "inventory_item_name")
    public ExtendedWebElement itemName;
    @FindBy(className = "inventory_item_desc")
    public ExtendedWebElement itemDescription;
    @FindBy(className = "inventory_item_price")
    public ExtendedWebElement itemPrice;

    @FindBy(xpath = "//div[contains('Add to cart')")
    public ExtendedWebElement addToCartButton;


    public Item(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public InventoryItem clickItemName() {
        itemName.click();
        return new InventoryItem(getDriver());
    }

    public String readItemName() {
        return itemName.getText();
    }

    public String readItemDescription() {
        return itemDescription.getText();
    }

    public String readItemPrice() {
        return itemPrice.getText();
    }
}
