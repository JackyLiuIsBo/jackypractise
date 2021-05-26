package basic.lru;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName simpleLru
 * @Description
 * @Author liubo
 * @Date 2021/5/20 10:50 下午
 **/
public class LRUCache {
    //int size = 0;
    //LinkedList<Integer> list ;
    //Map<Integer,Integer> map ;
    //public LRUCache(int capacity) {
    //    size = capacity;
    //    list = new LinkedList();
    //    map = new HashMap();
    //}
    //
    //public int get(int key) {
    //    if(!list.contains(key)){
    //        return -1;
    //    }
    //    moveToFirst(key);
    //    return map.get(key);
    //}
    //
    //public void put(int key, int value) {
    //    if(list.contains(key)){
    //        moveToFirst(key);
    //        map.put(key,value);
    //    }else{
    //        if(list.size() == size){
    //            map.remove(list.removeLast());
    //        }
    //        list.addFirst(key);
    //        map.put(key,value);
    //    }
    //}
    //
    //public void moveToFirst(int key){
    //    list.remove((Integer)key);
    //
    //    list.addFirst(key);
    //}
    private int capacity ;
    private Map<Integer,Integer> map ;
    private LinkedList<Integer> list;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        list = new LinkedList();
    }

    public int get(int key) {
        if(!list.contains(key)){
            return -1;
        }

        moveToFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if(list.contains(key)){
            moveToFirst(key);
            map.put(key,value);
        }else{
            if(list.size() >= capacity){
                map.remove(list.removeLast());
            }
            list.addFirst(key);
            map.put(key,value);
        }


    }

    private void moveToFirst(Integer key){
        list.remove(key);
        list.addFirst(key);
    }
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.get(1);
        lru.put(3, 3);
        System.out.println(lru);
        Integer c = lru.get(2);
        lru.put(4,4);
        lru.get(1);
        lru.get(3);
        lru.get(4);
        System.out.println(lru);



        System.out.println(lru);
    }
}
