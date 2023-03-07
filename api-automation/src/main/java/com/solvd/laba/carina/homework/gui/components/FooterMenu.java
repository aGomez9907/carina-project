package com.solvd.laba.carina.homework.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {
    @FindBy(className = "social_twitter")
    private ExtendedWebElement twitterButton;
    @FindBy(className = "social_facebook")
    private ExtendedWebElement facebookButton;
    @FindBy(className = "social_linkedin")
    private ExtendedWebElement linkedinButton;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public void clickTwitter() {
        twitterButton.click();
    }

    public void clickFacebook() {
        facebookButton.click();
    }

    public void clickLinkedin() {
        linkedinButton.click();
    }
}
