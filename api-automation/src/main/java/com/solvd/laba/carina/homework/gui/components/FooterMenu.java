package com.solvd.laba.carina.homework.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.laba.carina.homework.gui.pages.FacebookPage;
import com.solvd.laba.carina.homework.gui.pages.LinkedinPage;
import com.solvd.laba.carina.homework.gui.pages.TwitterPage;
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


    public TwitterPage clickTwitter() {
        twitterButton.click();
        return new TwitterPage(getDriver());
    }

    public FacebookPage clickFacebook() {
        facebookButton.click();
        return new FacebookPage(getDriver());
    }

    public LinkedinPage clickLinkedin() {
        linkedinButton.click();
        return new LinkedinPage(getDriver());
    }
}
