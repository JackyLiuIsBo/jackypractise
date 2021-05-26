package pracktiseskill.SortAlogrithm;

import java.util.Arrays;

/**
 * @ClassName mergNums
 * @Description
 * @Author liubo
 * @Date 2021/5/4 11:10 下午
 **/
public class mergNums {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};
        reMerge(nums1,3,nums2,3);
    }


    private static void reMerge(int[] nums1, int m, int[] nums2, int n){
        int i = m - 1;
        int j = n - 1;
        int end = m + n - 1;
        while (j >= 0) {
            nums1[end--] = (i >= 0 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int [] temp = new int[m + n];
        int left =0,right = 0,t = 0;
        while (m > left   && n > right){
            while (m > left  && nums1[left] < nums2[right]){
                temp[t++]  = nums1[left++];
            }
            while (m > left  && n > right && nums1[left] >= nums2[right]){
                temp[t++]  = nums2[right++];
            }
        }
        while (left  < m){
            temp[t++] = nums1[left++];
        }

        while (right < n){
            temp[t++] = nums2[right++];
        }
        for(int i = 0; i < m + n ; i++){
            nums1[i] = temp[i];
        }
        System.out.println(Arrays.toString(nums1));

    }
}
