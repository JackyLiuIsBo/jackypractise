package pracktiseskill.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @ClassName RandomizedSet
 * @Description
 * @Author liubo
 * @Date 2021/5/9 2:58 下午
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 *
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xagm3s/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class RandomizedSet {
    //使用hashMap和ArrayList来保存
    HashMap<Integer,Integer> map ;
    ArrayList<Integer> list;
    Random random ;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val,list.size());
        list.add(list.size(),val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return  false;
        }
        Integer index = map.get(val);
        Integer element = list.get(list.size() - 1);
        list.add(index,element);
        map.put(element,index);
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
