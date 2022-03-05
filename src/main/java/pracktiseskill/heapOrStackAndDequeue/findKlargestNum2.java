package pracktiseskill.heapOrStackAndDequeue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * @ClassName findKlargestNum2
 * @Description
 * @Author liubo
 * @Date 2021/5/8 6:46 下午
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  

 **/
public class findKlargestNum2 implements Comparable{

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return map.get(o1) - map.get(o2);
        });

        for(Integer key : map.keySet()){
            if (queue.size() < k){
                queue.add(key);
            }else {
                if (map.get(key) > map.get(queue.peek())){
                    queue.poll();
                    queue.add(key);
                }
            }
        }
        int [] result = new int[k];
        int count = 0;
        while (!queue.isEmpty()){
            result[count++] = queue.poll();
        }
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
