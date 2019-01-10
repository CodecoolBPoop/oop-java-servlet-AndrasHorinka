package com.codecool.servlet;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    public List<Item> items = new ArrayList<>();


    public void addItem(Item item) {
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public Item getItemById(int id) {
        for (Item item : this.items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
