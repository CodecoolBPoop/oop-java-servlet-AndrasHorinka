package com.codecool.servlet;

public class Item {
    private static int itemsCreated = 0;
    private int id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.id = itemsCreated;
        this.name = name;
        this.price = price;
        itemsCreated += 1;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
