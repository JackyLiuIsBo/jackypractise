package leetcode.lru;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @ClassName linkedListLRU
 * @Description
 * @Author liubo
 * @Date 2020/11/9 2:53 下午
 **/
public class linkedListLRU<K,V> {
    class LRUCache {
        int capacity1 = 0;
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap();

        public LRUCache(int capacity) {
            capacity = capacity;
            map = new LinkedHashMap<Integer, Integer>(capacity,1,true){
                @Override
                protected boolean removeEldestEntry(Entry eldest) {
                    return this.size() > capacity1;
                }
            };

        }

        public int get(int key) {
           return map.get(key);

        }

        public void put(int key, int value) {
            map.put(key,value);
        }
    }


    private final int size  ;

    private float loadFactory = 0.75f;

    private LinkedHashMap<K,V> map = null;

    linkedListLRU(){
        this(16,0.75f);
    }

    linkedListLRU(int size){
        this(size,0.75f);
    }

    public linkedListLRU(int size,float loadFactory){
        this.size = size;
        this.loadFactory = loadFactory;
         map = new LinkedHashMap<K, V>(size,1,true){
            @Override
            protected boolean removeEldestEntry(Entry eldest) {
                return this.size() > size;
            }
        };

    }

    public void put(K key,V value){
        map.put(key,value);
    }

    public V get(K key){
       return map.get(key);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        map.entrySet().stream().forEach(entry -> {
           stringBuilder.append( entry.getKey() + " ");
        });
        return stringBuilder.toString();
    }

    public static void main(){
        linkedListLRU<String,String> lru = new linkedListLRU(4,0.8f);
    }
    public static void main(String[] args) {
        //LRU<Integer,Integer> lru = new LRU(3);
        //lru.put(1,1);
        //lru.put(2,2);
        //lru.put(3,3);
        //System.out.println(lru);
        //lru.get(1);
        //System.out.println(lru);
        //lru.put(5,5);
        ////lru.put(6,6);
        ////lru.put(7,7);
        //System.out.println(lru);
    }
}
