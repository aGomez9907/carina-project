package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.laba.carina.homework.gui.components.FooterMenu;
import com.solvd.laba.carina.homework.gui.components.Header;
import com.solvd.laba.carina.homework.gui.components.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends AbstractPage {

    @FindBy(id = "header_container")
    private Header header;
    @FindBy(className = "footer")
    private FooterMenu footer;
    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<Item> items;


    public InventoryPage(WebDriver driver) {
        super(driver);
        setPageURL("inventory.html");
    }

    public InventoryItem selectItemByName(String name) {
        InventoryItem ii = null;
        for (Item i : items) {
            if (i.readItemName().equals(name)) {
                ii = i.clickItemName();
                break;
            }
        }
        return ii;
    }

    public List<Double> getItemPrices() {
        List<Double> prices = new ArrayList<Double>();
        items.forEach(e -> {
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
        return !driver.findElements(By.xpath("//img[@src= '/static/media/sl-404.168b1cce.jpg']")).isEmpty();
    }

    public List<Item> getItems() {
        return items;
    }
}
