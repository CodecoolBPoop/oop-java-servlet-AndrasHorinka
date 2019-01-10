package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServlet {

    public static List<Item> cart = new ArrayList<>();

    public static void buyItem(Item item) {
        ShoppingCartServlet.cart.add(item);
    }

    public static void revokeBuy(Item item) {
        ShoppingCartServlet.cart.remove(item);
    }


}
