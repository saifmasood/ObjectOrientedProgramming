package com.oop.catalog;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public interface Indexer {
    public boolean addIndex(Field field, Map<String,Item> map);
    public void addEntry(String word , Item item);
    public List<Item> searchEntries(String word, int limit);
}
