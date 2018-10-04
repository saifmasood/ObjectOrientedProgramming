package com.oop.vendingmachine;

import java.util.List;

public class VendingMachineImpl implements VendingMachine {

    Inventory<Coin> cashInventory;
    Inventory<Item> itemInventory;
    Item curItem;
    int curBalance;

    VendingMachineImpl(){
        curBalance = 0;
        init();
    }

    private void init(){
        cashInventory = new Inventory<>();
        itemInventory = new Inventory<>();

        for(Coin coin : Coin.values()){
            cashInventory.put(coin,5);
        }

        for(Item item : Item.values()){
            itemInventory.put(item,5);
        }
    }


    public int selectItemAndGetPrice(Item item){
      return 1;
    }

    public void insertCoin(Coin coin){

    }

    public List<Coin> refund(){

    }

    public  Bucket<Coin,Item> dispenseItemAndChange(){

    }

    public  void reset(){

    }

}
