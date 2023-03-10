package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryItemPage extends AbstractPage {

    @FindBy(className = "inventory_details_name")
    private ExtendedWebElement productName;
    @FindBy(className = "inventory_details_desc")
    private ExtendedWebElement productDescription;
    @FindBy(className = "inventory_details_price")
    private ExtendedWebElement productPrice;
    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    private ExtendedWebElement addToCartButton;


    public InventoryItemPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productName);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public boolean assertInventoryItem(String name) {
        return productName.getText().equals(name);
    }
}
