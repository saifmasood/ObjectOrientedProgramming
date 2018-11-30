package com.oop.catalog;

public class Trie {
    private final int SIZE = 26;
    private Trie[] alphabets;
    boolean isWord;
    Object ref;

    Trie(){
        alphabets = new Trie[SIZE];
        isWord = false;
    }

    public int getSIZE(){
        return SIZE;
    }

    public Trie[] getAlphabets() {
        return alphabets;
    }

    public boolean isWord() {
        return isWord;
    }

    public Object getRef() {
        return ref;
    }
}
