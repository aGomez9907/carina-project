package com.solvd.laba.carina.homework.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.laba.carina.homework.gui.pages.Facebook;
import com.solvd.laba.carina.homework.gui.pages.Linkedin;
import com.solvd.laba.carina.homework.gui.pages.Twitter;
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


    public Twitter clickTwitter() {
        twitterButton.click();
        return new Twitter(getDriver());
    }

    public Facebook clickFacebook() {
        facebookButton.click();
        return new Facebook(getDriver());
    }

    public Linkedin clickLinkedin() {
        linkedinButton.click();
        return new Linkedin(getDriver());
    }
}
