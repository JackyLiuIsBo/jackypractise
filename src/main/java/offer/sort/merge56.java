package offer.sort;/**
 * @program: jackypractise
 * @description: 合并区间
 * @author: liubo
 * @date: 2022-03-08 22:00
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 @ClassName merge56
 @Description
 @Author liubo
 @Date 2022/3/8 下午10:00
 **/
public class merge56 {

    public static void main(String[] args) {
        //int [][] nums = {{2,3},{2,6},{8,10},{1,18}};
        //int[][] merge = merge(nums);
        //System.out.println(Arrays.toString(merge));
        //HashMap<Integer,Integer> map = new HashMap<>();
       int []  array = {1,1,1,2,2,3};
        int[] ints = topKFrequent(array, 2);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] topKFrequent(int[] array, int pos) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int temp: array){
            map.put(temp,map.getOrDefault(temp,0) + 1);
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((int[] o1,int[]o2)->{
            return o2[1] - o1[1];
        });
        List<int[]> list = new ArrayList<int[]>();
        int[][] ints = list.toArray(new int[2][]);
        for (int num : map.keySet()){
            priorityQueue.offer(new int[]{num,map.get(num)});
        }
        list.toArray(new int[2][]);
        int [] result = new int[pos];

        while (pos > 0){
            result[pos-1] = priorityQueue.poll()[0];
            pos--;
        }
        return result;


    }





















    public static int[][] merge(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval: intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
