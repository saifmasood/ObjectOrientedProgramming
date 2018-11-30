package TrieDS;

import java.util.Map;

public class Trie {

    private TrieNode root;

    public TrieNode getRoot() {
        return root;
    }

    public Trie() {
        this.root = new TrieNode((char)0);
    }

    public void insert(String word){
        if(word == null)
            return;
        TrieNode t = root;
        int len = word.length();
        for(int i=0;i<len;i++){
            char c = word.charAt(i);
            Map<Character,TrieNode> child = t.getChildren();
            t = child.get(c);
            if(t == null){
                t = new TrieNode(c);
                child.put(c,t);
            }
        }
        t.setWordEnd(true);
    }

    public boolean search(String word){
        if(word == null)
            return true;
        TrieNode t = root;
        int len = word.length();
        for(int i=0;i<len;i++){
            char c = word.charAt(i);
            Map<Character,TrieNode> child = t.getChildren();
            t = child.get(c);
            if(t == null){
                return false;
            }
        }
        return t.getWordEnd();
    }



}
