package com.oop.vendingmachine;

import java.util.List;

public interface VendingMachine {

    public int selectItemAndGetPrice(Item item);

    public void insertCoin(Coin coin);

    public List<Coin> refund();

    public  Bucket<Coin,Item> dispenseItemAndChange();

    public  void reset();

}
