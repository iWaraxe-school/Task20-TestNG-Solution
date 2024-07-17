package com.coherentsolutions.java.webauto.parser;

import com.coherentsolutions.java.webauto.shop.Cart;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonParserTest {

    private final JsonParser jsonParser = new JsonParser();

    @Test(groups = "fast")
    public void testWriteToFile() throws IOException {
        Cart cart = new Cart("test-cart");
        jsonParser.writeToFile(cart);
        File file = new File("src/main/resources/test-cart.json");
        Assert.assertTrue(file.exists(), "File should be created");
        Files.deleteIfExists(Paths.get("src/main/resources/test-cart.json"));
    }

    @Test(groups = "fast")
    public void testReadFromFile() {
        File file = new File("src/main/resources/andrew-cart.json");
        Cart cart = jsonParser.readFromFile(file);
        Assert.assertNotNull(cart, "Cart should not be null");
        Assert.assertEquals(cart.getCartName(), "andrew-cart", "Cart name should be 'andrew-cart'");
    }

    @Test(expectedExceptions = NoSuchFileException.class, enabled = false)
    public void testReadFromNonExistentFile() {
        File file = new File("src/main/resources/nonexistent-cart.json");
        jsonParser.readFromFile(file);
    }

    @Test(groups = "slow", dataProvider = "invalidJsonFiles", expectedExceptions = JsonSyntaxException.class)
    public void testReadFromInvalidJson(File file) {
        jsonParser.readFromFile(file);
    }

    @DataProvider(name = "invalidJsonFiles")
    public Object[][] provideInvalidJsonFiles() {
        return new Object[][]{
                {new File("src/test/resources/invalid-json1.json")},
                {new File("src/test/resources/invalid-json2.json")},
                {new File("src/test/resources/invalid-json3.json")},
                {new File("src/test/resources/invalid-json4.json")},
                {new File("src/test/resources/invalid-json5.json")}
        };
    }
}