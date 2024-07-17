package com.coherentsolutions.java.webauto.shop;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GroupedAssertionTest {

    @Test
    public void testRealItemAttributes() {
        RealItem item = new RealItem();
        item.setName("BMW");
        item.setPrice(45000);
        item.setWeight(1600);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(item.getName(), "BMW", "Name should be BMW");
        softAssert.assertEquals(item.getPrice(), 45000.0, "Price should be 45000");
        softAssert.assertEquals(item.getWeight(), 1600.0, "Weight should be 1600");
        softAssert.assertAll();
    }
}
