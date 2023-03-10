package com.solvd.laba.carina.homework.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class Linkedin extends AbstractPage {
    public Linkedin(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.linkedin.com/company/sauce-labs/");
    }
}
