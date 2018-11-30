 package PriorityQueueDS;

import java.util.*;

public class PriorityQ<T> {
    private int size;
    private int N;
    private PriorityQueue<T> heap;
    Comparator comparator;

    PriorityQ(int n,Comparator comparator){
        heap = new PriorityQueue<>(comparator);
        N = n;
        size = 0;
        this.comparator = comparator;
    }


    public void addItem(T item){
        if(size == N) {
            if(comparator.compare(getTop(),item) == 1){
                extractTop();
                heap.add(item);
                size++;
            }
        }else{
            heap.add(item);
            size++;
        }
    }

    public void extractTop(){
        heap.poll();
        size--;
    }

    public T getTop(){
        return heap.peek();
    }

    public List getEntries() {
        List<T> list = new ArrayList<>();
        Iterator<T> iterator = heap.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }
}
