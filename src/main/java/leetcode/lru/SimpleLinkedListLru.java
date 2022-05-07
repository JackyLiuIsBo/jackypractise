package leetcode.lru;/**
 * @program: jackypractise
 * @description: 简单的LinkedListLRU实现
 * @author: liubo
 * @date: 2022-03-13 23:31
 **/

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 * @ClassName SimpleLinkedListLru
 * @Description
 * @Author liubo
 * @Date 2022/3/13 11:31 下午
 **/
public class SimpleLinkedListLru<E> extends LinkedHashMap<Integer, Integer> {
    private int capacity ;
    SimpleLinkedListLru(int capacity) {
        super(capacity,
            0.75f,
            true);
        this.capacity = capacity;

    }

    public Integer put(int key, int value) {
        return super.put(key, value);
    }
    public int get(int key) {
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }


}
