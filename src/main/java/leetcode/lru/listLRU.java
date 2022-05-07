package leetcode.lru;

import java.util.HashMap;
import java.util.LinkedList;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName listLRU
 * @Description
 * @Author liubo
 * @Date 2020/11/9 3:23 下午
 **/
public class listLRU<K,V> {
    private int size;

    private float loadFactory;

    private LinkedList<K> linkedList = null;

    private HashMap<K,V> map = null;

    listLRU(){
        this(16,0.75f);
    }

    listLRU(int size){
        this(size,0.75f);
    }

    listLRU(int size,float loadFactory){
        this.size = size;
        this.loadFactory = loadFactory;

        linkedList = new LinkedList<>();
        map = new HashMap<>();
    }


    public K put(K key,V value){
        if (map.containsKey(key)){
            moveToFirst(key);
        }else {
            if (linkedList.size() >= size){
                K lastKey = linkedList.removeLast();
                map.remove(lastKey);
            }
            linkedList.addFirst(key);
            map.put(key,value);
        }
        return key;
    }

    public V get(K key){
        moveToFirst(key);
        return map.get(key);
    }

    private void moveToFirst(K key) {

        linkedList.remove(key);

        linkedList.addFirst(key);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        linkedList.stream().forEach(t ->{
            str.append(t + " ");
        });

        return str.toString();
    }

    public static void main(String[] args) {


        //    System.out.println(lru);
    }
}
