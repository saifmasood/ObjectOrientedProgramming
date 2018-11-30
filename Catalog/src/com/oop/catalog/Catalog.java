package com.oop.catalog;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public abstract class Catalog {

    protected Map<String,Item> itemMap;
    protected Map<Field,Indexer> indexerMap;
    protected Map<Field,SortIndexer> sortIndexerMap;
    protected Class itemClass;

    public void addItem(Item item){
        item.primaryField.setAccessible(true);
        try {
            if (itemMap.get((String)item.primaryField.get(item)) == null) {
                itemMap.put((String)item.primaryField.get(item), item);
            }else {
                System.out.println("Item exists");
                return;
            }
        }catch (IllegalAccessException ex){
            System.out.println("Cannot access field " + item.primaryField.getName());
        }
    }

    public void removeItem(Item item){
        item.primaryField.setAccessible(true);
        try {
            itemMap.remove((String)item.primaryField.get(item));
        }catch (IllegalAccessException ex){
            System.out.println("Cannot access field " + item.primaryField.getName());
        }
    }

    public Item getItem(String key){
        Item item = itemMap.get(key);
        if(item == null){
            System.out.println("Item does not exist");
        }
        return item;
    }

    public void addIndex(String field){
        Field itemField = getValidItemField(field);
        if(itemField == null){
            System.out.println("Field "+ field + " is not valid");
        }
        if(indexerMap.get(field) == null){
            Indexer indexer = new TrieIndexer();
            boolean isAdded = indexer.addIndex(itemField,itemMap);
            if(isAdded){
                indexerMap.put(itemField,indexer);
            }else {
                System.out.println("Failed to add index");
            }
        }else{
            System.out.println("Index exists");
        }
    }

    public List<Item> searchIndex(String field, String key, int limit){
        Field itemField = getValidItemField(field);
        if(itemField == null){
            System.out.println("Field "+ field + " is not valid");
        }
        if(indexerMap.get(itemField) == null){
            addIndex(field);
        }
        Indexer indexer = indexerMap.get(itemField);
        return indexer.searchEntries(key,limit);
    }


    private Field getValidItemField(String field){
        for(Field f : itemClass.getDeclaredFields()){
            if(field.equalsIgnoreCase(f.getName())) {
                return f;
            }
        }
        return null;
    }

    public void addSortIndex(String field,String key){

    }

}
