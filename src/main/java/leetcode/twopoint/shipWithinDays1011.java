package leetcode.twopoint;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * @author: liubo
 * @date: 2022-06-02 23:51
 **/

/**
 @ClassName shipWithinDays1011
 @Description
 @Author liubo
 @Date 2022/6/2 11:51 PM
 **/
public class shipWithinDays1011 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1};
        int fix = shipWithinDays(nums, 4);
        System.out.println(fix);
    }

    private static int shipWithinDays(int[] nums, int days) {
        int left = 1,right = 0;

        for (int t : nums){
            left = Math.max(left,t);
            right += t;
        }
        while (left < right){
            int mid = (left + right) / 2;
            if (isFix(nums,mid) <= days){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static int isFix(int[] nums, int mid) {
        int days = 0;
        for (int i = 0; i < nums.length;){
            int temp = mid;

            while (i < nums.length && temp - nums[i] >= 0){
                temp -= nums[i];
                i++;
            }
            days++;
        }
        return days;
    }

    //public static int shipWithinDays(int[] weights, int days) {
    //    int left = 0,right = 500;
    //    while (left < right){
    //        int mid = (right + left) / 2;
    //        if (isFit(weights,days) <= mid){
    //            right = mid;
    //        }else {
    //            left = mid + 1;
    //        }
    //    }
    //    return left;
    //}
    //
    //private static int isFit(int [] weight,int speed){
    //    int days = 0;
    //    for (int i = 0; i < weight.length; i++){
    //        days += weight[i] / speed;
    //        if (weight[i] % speed != 0){
    //            days++;
    //        }
    //    }
    //    return days;
    //}
}
