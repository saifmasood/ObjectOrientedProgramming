package com.oop.catalog;

public class Test {

    public static void main(String[] args){
        Catalog catalog = new BookCatalog();

        Book book = new Book("Kite","Saif","Romance",3,"name");
        catalog.addItem(book);

        book = new Book("Dark","Akef","Horror",3,"name");
        catalog.addItem(book);

        book = new Book("Night","Saif","Romance",5,"name");
        catalog.addItem(book);

        book = new Book("Kite","Saif","Romance",2,"name");
        catalog.addItem(book);



    }
}
