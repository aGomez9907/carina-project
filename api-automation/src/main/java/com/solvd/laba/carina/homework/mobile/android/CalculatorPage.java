package com.solvd.laba.carina.homework.mobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.laba.carina.homework.mobile.common.CalculatorPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalculatorPageBase.class)
public class CalculatorPage extends CalculatorPageBase {

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"equals\"]")
    private ExtendedWebElement equalsButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"plus\"]")
    private ExtendedWebElement plusButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"minus\"]")
    private ExtendedWebElement minusButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"multiply\"]")
    private ExtendedWebElement multiplyButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"divide\"]")
    private ExtendedWebElement divideButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"percent\"]")
    private ExtendedWebElement percentButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"clear\"]")
    private ExtendedWebElement clearButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"delete\"]")
    private ExtendedWebElement deleteButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"point\"]")
    private ExtendedWebElement pointButton;


    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"0\"]")
    private ExtendedWebElement zeroButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"1\"]")
    private ExtendedWebElement oneButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"2\"]")
    private ExtendedWebElement twoButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"3\"]")
    private ExtendedWebElement threeButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"4\"]")
    private ExtendedWebElement fourButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"5\"]")
    private ExtendedWebElement fiveButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"6\"]")
    private ExtendedWebElement sixButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"7\"]")
    private ExtendedWebElement sevenButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"8\"]")
    private ExtendedWebElement eightButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"9\"]")
    private ExtendedWebElement nineButton;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.TextView")
    private ExtendedWebElement result;

    @FindBy(id = "collapse_expand")
    private ExtendedWebElement expandButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"square root\"]")
    private ExtendedWebElement sqrtButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"power\"]")
    private ExtendedWebElement pwrButton;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getResult() {
        return result;
    }

    @Override
    public boolean isPageOpened() {
        return equalsButton.isElementPresent();
    }

    public void clickExpand() {
        expandButton.click();
    }

    public void clickPwr() {
        pwrButton.click();
    }

    public void clickSqrt() {
        sqrtButton.click();
    }

    public void clickZero() {
        zeroButton.click();
    }

    public void clickOne() {
        oneButton.click();
    }

    public void clickTwo() {
        twoButton.click();
    }

    public void clickThree() {
        threeButton.click();
    }

    public void clickFour() {
        fourButton.click();
    }

    public void clickFive() {
        fiveButton.click();
    }

    public void clickSix() {
        sixButton.click();
    }

    public void clickSeven() {
        sevenButton.click();
    }

    public void clickEight() {
        eightButton.click();
    }

    public void clickNine() {
        nineButton.click();
    }

    public void clickEquals() {
        equalsButton.click();
    }

    public void clickPlus() {
        plusButton.click();
    }

    public void clickMinus() {
        minusButton.click();
    }

    public void clickMultiply() {
        multiplyButton.click();
    }

    public void clickDivide() {
        divideButton.click();
    }

    public void clickDelete() {
        deleteButton.click();
    }

    public void clickClear() {
        clearButton.click();
    }

    public void clickPoint() {
        pointButton.click();
    }

    public void clickPercent() {
        percentButton.click();
    }


}