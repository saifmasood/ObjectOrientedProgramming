package WindowDs;

import java.util.List;

public interface Window<K,V> {

    public void addItem(K key, V value);

    public List getTopK(int limit);

    public void remove(K key);

    public void printWindow();
}
