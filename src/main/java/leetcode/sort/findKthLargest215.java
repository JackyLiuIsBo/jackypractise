package leetcode.sort;

import java.util.Arrays;

public class findKthLargest215 {

    public static void main(String[] args) {
        int[] array = {3,2,1,5,6,4};
        int kthLargest1 = findKthLargest1(array, 2);
        System.out.println(kthLargest1 );
        System.out.println(Arrays.toString(array));
    }
    public static int findKthLargest1(int[] a, int k) {
        int n = a.length;
        int p = quickSelect(a, 0,n - 1, k);
        return a[p];
    }



    private static int quickSelect(int[] array,int left, int right, int k){
        int partion = partion(array, left, right);

        if (partion + 1 > k){
           return quickSelect(array,left,partion - 1,k);
        }else if (partion + 1 < k){
          return   quickSelect(array,partion+1,right,k);
        }
        return partion;
    }

    private static int partion(int[] nums,int left,int right){
        int temp = nums[right];
        while(left < right){
            while(left < right && nums[left] > temp){
                left++;
            }
            nums[right] = nums[left];
            while(left < right && nums[right] <= temp){
                right--;
            }
            nums[left] = nums[right];
        }
        nums[left] = temp;

        return left;

    }
    //
    //public int findKthLargest(int[] nums, int k) {
    //
    //
    //    int left = 0, right = nums.length-1;
    //    int i ;
    //    while (left < right){
    //        i = left;
    //        for (int j = i+1; j < right; j++){
    //            if (nums[j] < nums[i]){
    //                swap(nums,++i,j);
    //            }
    //            swap(nums,i,left);
    //            if (i == k) {
    //                return nums[i];
    //            }else if (i < k){
    //                left = i + 1;
    //            }else {
    //                right = i - 1;
    //            }
    //        }
    //
    //    }
    //    return -1;
    //
    //
    //
    //   /* k = nums.length - k; // convert to index of k largest
    //    int l = 0, r = nums.length - 1;
    //    while (l <= r) {
    //        int i = l; // partition [l,r] by A[l]: [l,i]<A[l], [i+1,j)>=A[l]
    //        for (int j = l + 1; j <= r; j++) {
    //            if (nums[j] < nums[l]) swap(nums, j, ++i);
    //        }
    //        swap(nums, l, i);
    //
    //        if (k < i) r = i - 1;
    //        else if (k > i) l = i + 1;
    //        else return nums[i];
    //    }
    //    return -1; // k is invalid*/
    //}
    //
    //// return the index of the kth smallest number
    ////int quickSelect(int[] a, int lo, int hi, int k) {
    ////    // use quick sort's idea
    ////    // put nums that are <= pivot to the left
    ////    // put nums that are  > pivot to the right
    ////    int i = lo, j = hi, pivot = a[hi];
    ////    while (i < j) {
    ////        if (a[i++] > pivot) {
    ////            swap(a, --i, --j);
    ////        }
    ////    }
    ////    swap(a, i, hi);
    ////
    ////    // count the nums that are <= pivot from lo
    ////    int m = i - lo + 1;
    ////
    ////    // pivot is the one!
    ////    if (m == k)     return i;
    ////        // pivot is too big, so it must be on the left
    ////    else if (m > k) return quickSelect(a, lo, i - 1, k);
    ////        // pivot is too small, so it must be on the right
    ////    else            return quickSelect(a, i + 1, hi, k - m);
    ////}
    ////
    ////void swap(int[] a, int i, int j) {
    ////    int tmp = a[i];
    ////    a[i] = a[j];
    ////    a[j] = tmp;
    ////}
}
