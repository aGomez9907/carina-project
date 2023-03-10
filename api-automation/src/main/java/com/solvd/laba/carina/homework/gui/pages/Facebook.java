package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class Facebook extends AbstractPage {
    public Facebook(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.facebook.com/saucelabs");
    }
}
