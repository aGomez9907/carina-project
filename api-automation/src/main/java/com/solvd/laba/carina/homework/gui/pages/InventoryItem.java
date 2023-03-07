package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryItem extends AbstractPage {

    @FindBy(xpath = "//div[@class='inventory_details_name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//div[@class='inventory_details_desc']")
    private ExtendedWebElement productDescription;
    @FindBy(xpath = "//div[@class='inventory_details_price']")
    private ExtendedWebElement productPrice;

    public InventoryItem(WebDriver driver, int id) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productName);
        setUiLoadedMarker(productDescription);
        setUiLoadedMarker(productPrice);
    }
}
