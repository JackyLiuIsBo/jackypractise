package leetcode.lru;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache2<K,V> {
    private final int cacheSize;
    private LinkedList<K> cacheList = new LinkedList<>();
    private HashMap<K,V> map = new HashMap<>();

    public LRUCache2(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    public synchronized void put(K key, V val) {
        if (!(map.containsKey(key))) {
            if (cacheList.size() >= cacheSize) {
                removeLastElement();
            }
            cacheList.addFirst(key);
            map.put(key, val);
        } else {
            map.put(key,val);
            moveToFirst(key);
        }
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        moveToFirst(key);
        return map.get(key);
    }

    private synchronized void moveToFirst(K key) {
        cacheList.remove(key);
        cacheList.addFirst(key);
    }

    private synchronized void removeLastElement() {
        K key = cacheList.removeLast();
        map.remove(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return map.toString();

    }

    public static void main(String[] args) {
        LRUCache2<Integer,Integer> lru = new LRUCache2<>(2);

        lru.put(2, 6);
        lru.get(1);
        lru.put(1,5);
        lru.put(1,2);
        lru.get(2);
        System.out.println(lru.toString());
        Integer integer = lru.get(2);
        System.out.println(integer);
        System.out.println(lru);
        lru.put(1,1);
        lru.put(4, 1);
        lru.get(2);


        System.out.println(lru);
    }
}