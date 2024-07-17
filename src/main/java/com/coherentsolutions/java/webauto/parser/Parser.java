package com.coherentsolutions.java.webauto.parser;

import com.coherentsolutions.java.webauto.shop.Cart;

import java.io.File;

public interface Parser {

    void writeToFile(Cart cart);
    Cart readFromFile(File file);
}