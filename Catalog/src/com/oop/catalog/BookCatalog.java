package com.oop.catalog;

import java.util.HashMap;

public class BookCatalog extends Catalog {

    BookCatalog(){
        itemMap = new HashMap<>();
        indexerMap = new HashMap<>();
        sortIndexerMap = new HashMap<>();
        itemClass = Book.class;
    }


}
