package leetcode.math;

import java.util.Arrays;

public class containsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }
    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
}
