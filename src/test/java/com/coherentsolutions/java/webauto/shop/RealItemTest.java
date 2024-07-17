package com.coherentsolutions.java.webauto.shop;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RealItemTest {
    RealItem realItem;

    @BeforeMethod
    public void setUp() {
        realItem = new RealItem();
    }

    @AfterMethod
    public void tearDown() {
        realItem = null;
    }

    @Test
    public void testWeight() {
        double weight = 1500.5;
        realItem.setWeight(weight);
        Assert.assertEquals(realItem.getWeight(), weight, "Weight should match");
    }
}