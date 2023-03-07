package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.laba.carina.homework.gui.components.FooterMenu;
import com.solvd.laba.carina.homework.gui.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends AbstractPage {

    @FindBy(id = "header_container")
    private Header header;
    @FindBy(className = "footer")
    private FooterMenu footer;
    @FindBy(id = "item_4_title_link")
    private ExtendedWebElement backpack;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private ExtendedWebElement addBackpackButton;

    @FindBy(className = "inventory_item_price")
    private List<ExtendedWebElement> itemPrices;


    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageURL("inventory.html");
    }


    public InventoryItem clickBackpack() {
        backpack.click();
        return new InventoryItem(getDriver(), 4);
    }


    public void addBackpack() {
        addBackpackButton.click();
    }

    public List<Double> getItemPrices() {
        List<Double> prices = new ArrayList<Double>();
        itemPrices.forEach(e -> {
            prices.add(Double.parseDouble(e.getText().replaceAll("[$]", "")));
        });
        return prices;
    }

    public Header getHeader() {
        return header;
    }

    public FooterMenu getFooter() {
        return footer;
    }
}
