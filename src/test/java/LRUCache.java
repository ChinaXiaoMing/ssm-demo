import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap {

    private int MAX_SIZE;

    public LRUCache(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        MAX_SIZE = initialCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_SIZE;
    }
}
