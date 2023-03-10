package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class Twitter extends AbstractPage {
    public Twitter(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://twitter.com/saucelabs");
    }
}
