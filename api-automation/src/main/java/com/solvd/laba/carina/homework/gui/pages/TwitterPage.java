package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class TwitterPage extends AbstractPage {
    public TwitterPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://twitter.com/saucelabs");
    }
}
