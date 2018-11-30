package TrieDS;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private char ch;
    private Map<Character,TrieNode> children;
    private boolean wordEnd;

    public TrieNode(char ch) {
        this.ch = ch;
        this.children = new HashMap<>();
        this.wordEnd = false;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieNode> children) {
        this.children = children;
    }

    public boolean getWordEnd() {
        return wordEnd;
    }

    public void setWordEnd(boolean status) {
        this.wordEnd = status;
    }
}
