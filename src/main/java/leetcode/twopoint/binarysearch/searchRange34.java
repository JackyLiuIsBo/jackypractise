package leetcode.twopoint.binarysearch;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author: liubo
 * @date: 2022-05-31 23:51
 **/

import java.util.Arrays;

/**
 @ClassName searchRange34
 @Description
 @Author liubo
 @Date 2022/5/31 11:51 PM
 **/
public class searchRange34 {
    public static void main(String[] args) {
        int [] nums = {1};
        int target = 1;
        int[] ints = searchRange(nums, 1);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        int [] result = {-1,-1};

        if (!isInArray(nums,target)){
            return result;
        }
        result[0] = left;
        result[1] = right;
        return result;
    }
    private static boolean isInArray(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        //此处需要放上等于号，否则会无法判断{1}的情况
        while (left <= right){
            int mid = left + (right - left ) / 2;
            if (nums[mid] == target){
                return true;
            }
            //此处需要使用mid + 1和mid - 1
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    private static int searchRight(int[] nums, int target) {
        int left = 0,right = nums.length ;
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

    private static int searchLeft(int[] nums, int target) {
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
}
