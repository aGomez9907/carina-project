package com.solvd.laba.carina.homework.gui.dataprovider;


import org.testng.annotations.DataProvider;

public class CheckoutProvider {

    @DataProvider(name = "CheckoutData")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"pop", "eye", "B1234"},
                {"Juan", "Veron", "A4321"},
        };


    }
}