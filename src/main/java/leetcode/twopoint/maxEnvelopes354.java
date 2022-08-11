package leetcode.twopoint;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/russian-doll-envelopes/
 * @author: liubo
 * @date: 2022-06-01 21:42
 **/

import java.util.Arrays;
import java.util.Comparator;

/**
 @ClassName maxEnvelopes354
 @Description
 @Author liubo
 @Date 2022/6/1 9:42 PM
 **/
public class maxEnvelopes354 {
    public static void main(String[] args) {
        int[] [] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int i = maxEnvelopes(envelopes);
        System.out.println(i);
    }
    public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0
            || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0) {
                index = -(index + 1);
            }
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }




    static int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;

    }
}
