package leetcode.twopoint.binarysearch;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/binary-search/
 * @author: liubo
 * @date: 2022-05-31 23:44
 **/

/**
 @ClassName binarySearch704
 @Description
 @Author liubo
 @Date 2022/5/31 11:44 PM
 **/
public class binarySearch704 {
    public static void main(String[] args) {
        int[] nums ={-1,0,3,5,9,12};
        int search = search(nums, 9);
        System.out.println((4-1) >> 1);
        System.out.println(search);
    }
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //此处需要放上等于号，否则会无法判断{1}的情况
        while (left <= right){
            int mid = left + (right - left ) / 2;
            if (nums[mid] == target){
                return mid;
            }
            //此处需要使用mid + 1和mid - 1
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
