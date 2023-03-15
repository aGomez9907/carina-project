package com.solvd.laba.carina.homework.mobile;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.solvd.laba.carina.homework.mobile.common.CalculatorPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorTest extends AbstractTest {

    @BeforeMethod
    public CalculatorPageBase startCalculator() {
        CalculatorPageBase calculator = initPage(getDriver(), CalculatorPageBase.class);
        Assert.assertTrue(calculator.isPageOpened());
        return calculator;
    }

    @Test
    @MethodOwner(owner = "agomez")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testSum() {
        CalculatorPageBase calculator = startCalculator();

        double sum = 12 + 6.45;
        calculator.clickOne();
        calculator.clickTwo();
        calculator.clickPlus();
        calculator.clickSix();
        calculator.clickPoint();
        calculator.clickFour();
        calculator.clickFive();
        calculator.clickEquals();
        Assert.assertEquals(calculator.getResult().getText(), String.valueOf(sum));

    }

    @Test
    @MethodOwner(owner = "agomez")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testMultiplication() {
        CalculatorPageBase calculator = startCalculator();

        double multiply = 12 * 6.45;
        calculator.clickOne();
        calculator.clickTwo();
        calculator.clickMultiply();
        calculator.clickSix();
        calculator.clickPoint();
        calculator.clickFour();
        calculator.clickFive();
        calculator.clickEquals();
        Assert.assertEquals(calculator.getResult().getText(), String.valueOf(multiply));

    }

    @Test
    @MethodOwner(owner = "agomez")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testDivision() {
        CalculatorPageBase calculator = startCalculator();

        double division = 12 / 6.45;
        String div = new BigDecimal(division).setScale(12, RoundingMode.HALF_UP).toString();
        calculator.clickOne();
        calculator.clickTwo();
        calculator.clickDivide();
        calculator.clickSix();
        calculator.clickPoint();
        calculator.clickFour();
        calculator.clickFive();
        calculator.clickEquals();
        Assert.assertEquals(calculator.getResult().getText(), div);

    }

    @Test
    @MethodOwner(owner = "agomez")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testSubtraction() {
        CalculatorPageBase calculator = startCalculator();

        double subtraction = 12 - 6.45;
        calculator.clickOne();
        calculator.clickTwo();
        calculator.clickMinus();
        calculator.clickSix();
        calculator.clickPoint();
        calculator.clickFour();
        calculator.clickFive();
        calculator.clickEquals();
        Assert.assertEquals(calculator.getResult().getText(), String.valueOf(subtraction));

    }

    @Test
    @MethodOwner(owner = "agomez")
    @TestLabel(name = "feature", value = {"mobile", "acceptance"})
    public void testPower() {
        CalculatorPageBase calculator = startCalculator();

        double sqrt = Math.pow(23, 3);
        Double s = new BigDecimal(sqrt).setScale(12, RoundingMode.HALF_DOWN).doubleValue();
        calculator.clickTwo();
        calculator.clickThree();
        calculator.clickPwr();
        calculator.clickThree();
        calculator.clickEquals();
        Assert.assertEquals(Double.parseDouble(calculator.getResult().getText()), s);

    }


}
