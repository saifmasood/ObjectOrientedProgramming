package com.oop.catalog;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TrieIndexer implements Indexer {

    private Trie trie;

    TrieIndexer(){
        trie = new Trie();
    }

    @Override
    public boolean addIndex(Field field, Map<String,Item> itemMap){

        Iterator<Map.Entry<String, Item>> itr = itemMap.entrySet().iterator();

        while(itr.hasNext()){
            Map.Entry<String, Item> entry = itr.next();
            Item item = entry.getValue();
            try {
                addEntry((String) field.get(item), item);
            }catch (IllegalAccessException e){
                return false;
            }
        }
        return true;
    }

    public void addEntry(String word,Item item){
        if(item == null)
            return;
        Trie t = trie;
        word = word.toLowerCase();
        for(int i=0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
            if(index > t.getSIZE())
                return;
            if(t.getAlphabets()[index] == null) {
                t.getAlphabets()[index] = new Trie();
            }
            t = t.getAlphabets()[index];
        }
        t.isWord = true;
        t.ref = item;
    }

    public List<Item> searchEntries(String word, int limit){
        Trie t = trie;
        word = word.toLowerCase();
        for(int i=0 ; i < word.length() ; i++){
            int index = word.charAt(i) - 'a';
            if(index > t.getSIZE())
                return null;
            if(t.getAlphabets()[index] == null) {
                return null;
            }
            t = t.getAlphabets()[index];
        }
        List<Item> itemList = new ArrayList<>();
        getEntries(t,limit,itemList);
        return itemList;
    }

    private void getEntries(Trie t,int limit,List<Item> itemList){
        if( t == null || itemList.size() == limit)
            return;
        if( t.ref != null)
            itemList.add((Item)t.ref);
        for(int i=0;i<trie.getSIZE();i++){
            getEntries(t.getAlphabets()[i],limit,itemList);
        }

    }
}
