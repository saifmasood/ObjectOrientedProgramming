package com.oop.vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {

    private Map<T,Integer> inventory;

    public Inventory() {
        this.inventory = new HashMap<>();
    }

    public void add(T t){
        inventory.put(t,inventory.getOrDefault(t,0) + 1);
    }

    public void remove(T t){
        int count = inventory.getOrDefault(t,0);
        if(count > 1){
            inventory.put(t,count - 1);
        }else{
            inventory.remove(t);
        }
    }

    public boolean hasItem(T t){
        return inventory.getOrDefault(t,0) > 0;
    }

    public void put(T t,int count){
        inventory.put(t,count);
    }
}
