package leetcode.math;

public class merge {
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int [] nums2 = {1,2,3};
        int n = 3;
//        merge(nums1,3,nums2,3);
        StringBuilder sb = new StringBuilder();
         sb.append(Character.toLowerCase('A'));
        System.out.println(sb.toString());
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n - 1;
        int i = 0;
        for( i = length; i >= 0 && m >0 && n > 0; i--){
            if(nums1[m-1] < nums2[n-1]){
                nums1[i] = nums2[n-1];
                n--;
            }else{
                nums1[i] = nums1[m-1];
                m--;
            }
        }
        if(n > 0){
            nums1[i--] = nums2[n-1];
            n--;
        }
        if(m > 0){
            nums1[i--] = nums1[m-1];
            m--;
        }
    }
}
