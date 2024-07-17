package com.coherentsolutions.java.webauto.shop;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VirtualItemTest {
    VirtualItem virtualItem;

    @BeforeMethod
    public void setUp() {
        virtualItem = new VirtualItem();
    }

    @AfterMethod
    public void tearDown() {
        virtualItem = null;
    }

    @Test
    public void testSizeOnDisk() {
        double sizeOnDisk = 2048.0;
        virtualItem.setSizeOnDisk(sizeOnDisk);
        Assert.assertEquals(virtualItem.getSizeOnDisk(), sizeOnDisk, "Size on disk should match");
    }
}