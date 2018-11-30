package com.oop.vendingmachine;

import java.util.ArrayList;
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

    @Override
    public int selectItemAndGetPrice(Item item){
        if(itemInventory.hasItem(item)){
            curItem = item;
            return curItem.getPrice();
        }else{
            System.out.println("Item " + item.getName() + " is not available");
            return -1;
        }

    }

    @Override
    public void insertCoin(Coin coin){
        curBalance += coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public  void reset(){
        curBalance = 0;
        curItem = null;
        itemInventory.clear();
        cashInventory.clear();
    }

    @Override
    public List<Coin> refund(){
        return new ArrayList<>();
    }

    @Override
    public  Bucket<Coin,Item> dispenseItemAndChange(){
        return new Bucket<>(Coin.DIME,Item.COKE);
    }

    public void collectItem(){
        if(isFullPaid()){
            List<Coin> change = ChangeUtil.getChange(cashInventory);
            if(change.size() == 0 ) {
                System.out.println("Insufficient change");
                return;
            }
            for(Coin coin : change)
                cashInventory.deduct(coin);
        }else{
            System.out.println("Please pay in full");
        }
    }


    public boolean isFullPaid(){
        return curBalance >= curItem.getPrice();
    }

}
