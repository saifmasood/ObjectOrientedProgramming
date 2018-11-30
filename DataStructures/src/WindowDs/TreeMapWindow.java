package WindowDs;

import java.util.*;
import java.util.Map;

public class TreeMapWindow<K extends Comparable<K>,V> implements Window<K,V>{
    private int size;
    private int N;
    private TreeMap<K,V> window;

    TreeMapWindow(int n){
        window = new TreeMap<>(Collections.reverseOrder());
        size = 0;
        N = n;
    }

    public int getSize() {
        return size;
    }

    public void addItem(K key,V value){
        V v;
        if(size == N) {
            Map.Entry<K,V> entry = window.lastEntry();
            if(key.compareTo(entry.getKey()) > 0) {
                window.pollLastEntry();
                window.put(key, value);
            }
        }else{
            window.put(key,value);
            size++;
        }
    }

    public List<K> getTopK(int limit){
        List<K> list = new ArrayList<>();
        Iterator<Map.Entry<K,V>> iterator = window.entrySet().iterator();
        int count = limit > size ? size : limit;
        while(iterator.hasNext() && count > 0){
            Map.Entry<K,V> entry = iterator.next();
            list.add(entry.getKey());
            count--;
        }
        return list;
    }

    public void remove(K key){
        if(size > 0 ){
            window.remove(key);
            size--;
        }
    }

    public void printWindow(){
        Iterator<Map.Entry<K,V>> iterator = window.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<K,V> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
