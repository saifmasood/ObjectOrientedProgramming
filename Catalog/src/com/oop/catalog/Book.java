package com.oop.catalog;

import java.lang.reflect.Field;

public class Book extends Item {

    private String name;
    private String author;
    private String category;
    private int sold;


    public Book(String name, String author, String category,int sold,String primaryField) {

        boolean isValid = false;
        for(Field field : Book.class.getDeclaredFields()) {
            try{
                if (primaryField.equalsIgnoreCase(Book.class.getField(primaryField).getName())) {
                    this.primaryField = Book.class.getField(primaryField);
                    break;
                }
            }catch (NoSuchFieldException ex) {
                System.out.println("Field " + primaryField + " does not exist");
                return;
            }
        }
        this.name = name;
        this.author = author;
        this.category = category;
        this.sold = sold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

}
