package TrieDS;

public class Test {

    public static void main(String[] args){
        Trie dict = new Trie();
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");
        dict.insert("basement");


        System.out.println(dict.search("area"));

        System.out.println(dict.search("are"));
        System.out.println(dict.search(null));

    }
}
