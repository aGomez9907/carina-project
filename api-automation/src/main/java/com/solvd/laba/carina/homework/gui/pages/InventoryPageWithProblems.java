package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryPageWithProblems extends AbstractPage {

    @FindBy(xpath = "//img[@src= '/static/media/sl-404.168b1cce.jpg']")
    private ExtendedWebElement problemJPG;

    public InventoryPageWithProblems(WebDriver driver) {
        super(driver);
        setPageURL("inventory.html");
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL_AND_ELEMENT);
        setUiLoadedMarker(problemJPG);
    }
}
