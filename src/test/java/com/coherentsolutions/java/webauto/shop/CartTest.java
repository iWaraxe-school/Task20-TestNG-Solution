package com.coherentsolutions.java.webauto.shop;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CartTest {
    Cart cart;

    @BeforeMethod
    public void setUp() {
        cart = new Cart("test-cart");
    }

    @AfterMethod
    public void tearDown() {
        cart = null;
    }

    @Test
    public void testAddRealItem() {
        RealItem item = new RealItem();
        item.setName("Audi");
        item.setPrice(30000);
        item.setWeight(1500);

        cart.addRealItem(item);
        Assert.assertTrue(cart.getTotalPrice() > 0, "Total price should be updated");
    }

    @Test
    public void testDeleteRealItem() {
        RealItem item = new RealItem();
        item.setName("Audi");
        item.setPrice(30000);
        item.setWeight(1500);

        cart.addRealItem(item);
        cart.deleteRealItem(item);
        Assert.assertEquals(cart.getTotalPrice(), 0.0, "Total price should be zero after removing item");
    }

    @Test
    @Parameters({"itemName", "itemPrice", "itemWeight"})
    public void testAddRealItemParameter(String itemName, double itemPrice, double itemWeight) {
        RealItem item = new RealItem();
        item.setName(itemName);
        item.setPrice(itemPrice);
        item.setWeight(itemWeight);
        cart.addRealItem(item);
        Assert.assertEquals(cart.getTotalPrice(), itemPrice * 1.2, "Total price should include tax");
    }
}