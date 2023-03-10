package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.laba.carina.homework.gui.components.FooterMenu;
import com.solvd.laba.carina.homework.gui.components.Header;
import com.solvd.laba.carina.homework.gui.components.ProductItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends AbstractPage {

    @FindBy(id = "header_container")
    private Header header;
    @FindBy(className = "footer")
    private FooterMenu footer;

    @FindBy(xpath = "//img[@src= '/static/media/sl-404.168b1cce.jpg']")
    private ExtendedWebElement problematicImage;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<ProductItem> productItems;


    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageURL("inventory.html");
    }

    public InventoryItemPage selectItemByName(String name) {
        InventoryItemPage ii = null;
        for (ProductItem i : productItems) {
            if (i.readItemName().equals(name)) {
                ii = i.clickItemName();
                break;
            }
        }
        return ii;
    }

    public List<Double> getItemPrices() {
        List<Double> prices = new ArrayList<Double>();
        productItems.forEach(e -> {
            prices.add(Double.parseDouble(e.readItemPrice().replaceAll("[$]", "")));
        });
        return prices;
    }

    public Header getHeader() {
        return header;
    }

    public FooterMenu getFooter() {
        return footer;
    }

    public boolean isProblematic() {
        return problematicImage.isElementPresent(3);
    }

    public List<ProductItem> getItems() {
        return productItems;
    }
}
