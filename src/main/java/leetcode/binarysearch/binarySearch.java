package leetcode.binarysearch;/**
 * @program: jackypractise
 * @description: 二分查找的模板
 * @author: liubo
 * @date: 2022-02-06 19:41
 **/

import java.util.*;

/**
 @ClassName binarySearch
 @Description
 @Author liubo
 @Date 2022/2/6 下午7:41
 **/
public class binarySearch {
    public static int findNthDigit (int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        // write code here
        // 0
        // 1 ~ 9      | digit = 1 start = 1 * 1       count = 1 * 9 * 1
        // 10 ~ 99    | digit = 2 start = 1 * 10      count = 10 * 9 * 2
        // 100 ~ 999  | digit = 3 start = 1 * 10 * 10 count = 100 * 9 * 3
        if (n <= 0) return 0;
        long start = 1, digit = 1, count = 9;
        while (n > count) {
            n -= count; // 减去当前位数的总长度
            start *= 10;
            digit += 1;
            count = start * 9 * digit;
        }

        HashMap<String,String> map = new HashMap<>();
        map.put("a","1");
        for(Map.Entry entry:  map.entrySet()){
            String key = (String) entry.getKey();
        }
        // 找到当前位数的区间了
        String num = (start + (n - 1) / digit) + ""; // 减去第0号元素0
        int idx = (int)((n - 1) % digit);
        return Integer.parseInt(num.charAt(idx) + "");
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3,3,3,5,7};
        int target = 3;
        int leftSearch = leftSearchTest(nums, 3);
        System.out.println("leftSearch: " + leftSearch);
        int right_bound = rightSearchTest(nums, 3);
        System.out.println("right:  " + right_bound);
    }

    private static int leftSearchTest(int[] nums,int target){
        int left = 0,right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                right = mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid;
            }
        }
        return left;
    }

    private static int rightSearchTest(int[] nums,int target){
        int left = 0,right = nums.length;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                left = mid + 1;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid;
            }
        }
        return left - 1;
    }



    static int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] == target) {
                // 直接返回
                return mid;
            }
        }
        // 直接返回
        return -1;
    }

    static int leftSearch(int[] nums,int target){
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 当找到 target 时，收缩右侧边界
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    static int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                // 当找到 target 时，收缩左侧边界
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
