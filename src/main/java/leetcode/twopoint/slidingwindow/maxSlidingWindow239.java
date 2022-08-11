package leetcode.twopoint.slidingwindow;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/sliding-window-maximum/
 * @author: liubo
 * @date: 2022-06-04 22:30
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 @ClassName maxSlidingWindow239
 @Description
 @Author liubo
 @Date 2022/6/4 10:30 PM
 **/
public class maxSlidingWindow239 {

    public static void main(String[] args) {
        int [] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }


    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++){
            if (!list.isEmpty() && list.peek() < i - k + 1){
                list.poll();
            }
            while (!list.isEmpty() && nums[i] > nums[list.peek()]){
                list.pollLast();
            }
            list.offer(i);
            if (!list.isEmpty() &&  i - k + 1 >= 0){
                result[i - k + 1] = nums[list.peek()];
            }

        }
        return  result;














        //int n = nums.length;
        //if (n == 0) {
        //    return nums;
        //}
        //int[] result = new int[n - k + 1];
        //LinkedList<Integer> dq = new LinkedList<>();
        //for (int i = 0; i < n; i++) {
        //    if (!dq.isEmpty() && dq.peek() < i - k + 1) {
        //        dq.poll();
        //    }
        //    while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
        //        dq.pollLast();
        //    }
        //    dq.offer(i);
        //    if (i - k + 1 >= 0) {
        //        result[i - k + 1] = nums[dq.peek()];
        //    }
        //}
        //return result;
    }
}
