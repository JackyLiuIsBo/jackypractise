package pracktiseskill.SortAlogrithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    private static Integer count = 0;
    public static void main(String[] args) {
        //int[] array = {1, 3, 2, 4, 5, 6, 7, 0};
        //mergeSort(array,0,array.length-1,new int[array.length]);
        //System.out.println(Arrays.toString(array));
        //List<Integer> list = new ArrayList<Integer>();
        //int[] objects = list.toArray(new int[0]);

        int[] nums = {1,3,4,2,2};
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            result ^= nums[i];
        }

        System.out.println(result);
    }

    public static int[] searchRange(int[] nums, int target) {

        int [] result = new int[]{-1,-1};

        if(nums.length == 0 ){
            return result;
        }


        result[0] = getLeft(nums,target);
        result[1] = getRight(nums,target);
        return result;
    }

    static int getLeft(int[] nums,int target){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                right = mid;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    static int getRight(int[] nums,int target){
        int left = 0, right = nums.length;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(target == nums[mid]){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private void sameMethod(){
        return;
    }

    private int sameMethod(int method,Long du){
        return 1;
    }

    private int sameMethod(Long du, int method){
        return 1;
    }



    static void mergeSort(int [] nums,int left, int right,int [] temp){
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums,left,mid,temp);
        mergeSort(nums,mid+1,right,temp);
        int start = mid,end = right;
        int t = right - left;
        while (start >= left && end > mid){

            if(nums[end] > nums[start]){
                temp[t--] = nums[end--];
            }else {
                temp[t--] = nums[start--];
            }
        }

        while (start >= left){
            temp[t--] = nums[start--];
        }

        while (end > mid){
            temp[t--] = nums[end--];
        }
        t = 0;
        while (left <= right){
            nums[left++] = temp[t++];
        }
    }

    private static void Sorts(int [] array){

        int [] temp = new int[array.length];
        int left = 0 , right = array.length-1;
        merge(array,temp,left,right);

    }

    private static void merge(int [] array,int [] temp,int left,int right){
        if (left < right){
            int mid = (right + left) / 2, t = right - left;
            merge(array,temp,left,mid);
            merge(array,temp,mid+1, right);
            //此处是从右到左进行判断
            int start = mid, end = right;
            while (start >= left &&  end > mid){
                if (array[start] < array[end]){
                    temp[t--] = array[end--];
                }else {
                    /**
                     * //否则，i就比j大，就说明出现了逆序对，因此维护count。
                     * //这里值得说道说道，temp的长度等于左边+右边的长度。既然有了排序的念头，那么合并之前也排好了
                     * //那么左边部分已经有序，右边部分也有序，比如此时进行{1,5,9}和{3,7,8}合并
                     * //则i=1,mid=2,j=3时进入else，可以看到，通过mid-i+1=2，拿到的是{5,3}，{9,3}两组逆序对
                     * //所以count+2,然后j的角标移动，下次比较的是5和7了。这样避免了重复的比较，提高了效率
                     * //这样的操作必须配合排序，如果不排序，就不能这么玩，而不能这么玩的时候，过程如下：
                     * //{1,5,9}和{3,7,8}合并,由于不知道是否有序，5和3形成逆序后，应当count++
                     * //然后移动一次你自己标记的指针。然后你总会通过移动指针比较一次9和3，然后count++。
                     * //而通过排序，这两个count++就变成了一次操作，因此，排序会提升效率，空间复杂度稍微高点。
                     * //因为你用到了额外的数组，合并排序，并且再复制给原数组
                     */
                    count += end - mid;
                    temp[t--] = array[start--];
                }
            }


            while (start >= left){
                temp[t--] = array[start--];
            }
            while (end > mid){
                temp[t--] = array[end--];
            }

            t = 0;

            while (left <= right){
                array[left++] = temp[t++];
            }

        }
    }
























    //private static void Sorts(int [] array){
    //    int [] temp = new int[array.length];
    //    merge(array,temp,0,array.length-1);
    //}
    //
    //private static void merge(int[] array, int[] temp, int left, int right) {
    //    if (left < right) {
    //        int mid = (left + right) / 2;
    //        merge(array, temp, left, mid);
    //        merge(array, temp, mid + 1, right);
    //        int start = mid, end = right, t = right - left;
    //
    //        while (start >= left && end > mid) {
    //            if (array[start] > array[end]) {
    //                temp[t--] = array[start--];
    //            } else {
    //                temp[t--] = array[end--];
    //            }
    //        }
    //
    //        while (start >= left) {
    //            temp[t--] = array[start--];
    //        }
    //
    //        while (end >= mid + 1) {
    //            temp[t--] = array[end--];
    //        }
    //        t = 0;
    //
    //        while (left <= right) {
    //            array[left++] = temp[t++];
    //        }
    //    }
    //
    //}





    //public static void Sorts(int [] array){
    //
    //    int [] temp = new int[array.length];
    //
    //    merge(array,temp,0,array.length-1);
    //
    //}
    //
    //public static void merge(int [] array,int [] temp,int left,int right){
    //
    //
    //    if(left < right){
    //
    //        int mid = (left + right) / 2;
    //
    //        merge(array,temp,left,mid);
    //        //关键在mid+1
    //        merge(array,temp,mid+1,right);
    //        int start = mid,end = right,t = right - left;
    //        while(start >= left && end > mid){
    //
    //            if(array[start] < array[end]){
    //                temp[t--] = array[end--];
    //            }else{
    //                temp[t--] = array[start--];
    //            }
    //
    //        }
    //
    //        while(start >= left){
    //            temp[t--] = array[start--];
    //        }
    //
    //        while(end > mid){
    //            temp[t--] = array[end--];
    //        }
    //
    //        t = 0;
    //        //这里需要写上等于
    //        while(left <= right){
    //            array[left++] = temp[t++];
    //        }
    //    }
    //
    //}















    //public static void Sorts(int [] array){
    //    int [] temp = new int[array.length];
    //    merge(array,temp,0,array.length-1);
    //}
    //
    //private static void merge(int[] array, int[] temp, int left, int right) {
    //    if (left < right){
    //        int mid = (left + right) / 2;
    //        merge(array,temp,left,mid);
    //        merge(array,temp,mid+1,right);
    //
    //        int start = mid,end = right,t = right - left;
    //
    //        while (start >= left && end > mid){
    //            if (array[start] > array[end]){
    //                    temp[t--] = array[start--];
    //            }else {
    //                temp[t--] = array[end--];
    //            }
    //        }
    //
    //        while (start >= left){
    //            temp[t--] = array[start--];
    //        }
    //
    //        while (end > mid){
    //         temp[t--] = array[end--];
    //        }
    //
    //        t = 0;
    //        while (left <= right){
    //            array[left++] = temp[t++];
    //        }
    //    }
    //}

    //private static void Sorts(int [] array){
    //    int left = 0,right = array.length - 1;
    //    int [] temp = new int[array.length];
    //    merge(left,right,array,temp);
    //}
    //
    //private static void merge(int left, int right, int[] array, int[] temp) {
    //    if (left < right) {
    //        int mid = (left + right) / 2;
    //
    //        merge(left, mid, array, temp);
    //        merge(mid + 1, right, array, temp);
    //        //t的取值是关键之一
    //        int start = mid, end = right, t = right - left;
    //        while (start >= left && end > mid) {
    //            if (array[start] > array[end]) {
    //
    //
    //                count += end - mid;
    //                temp[t--] = array[start--];
    //            } else {
    //                temp[t--] = array[end--];
    //            }
    //        }
    //        while (start >= left) {
    //            temp[t--] = array[start--];
    //        }
    //        while (end > mid) {
    //            temp[t--] = array[end--];
    //        }
    //        t = 0;
    //        while (left <= right) {
    //            array[left++] = temp[t++];
    //        }
    //    }
    //
    //}

    //private static void Sorts(int [] array){
    //    int left = 0, right = array.length - 1;
    //    merges(left,right,array);
    //
    //}
    //
    //private static void merges(int left, int right, int[] array) {
    //    if (left < right) {
    //        int mid = (left + right) / 2;
    //        merges(left, mid, array);
    //        merges(mid + 1, right, array);
    //
    //        int[] temp = new int[array.length];
    //        int start = mid,end = right,t = right - left;
    //        while (start >= left && end > mid){
    //            if (array[start] > array[end]){
    //                count += end - mid;
    //                temp[t--] = array[start--];
    //            }else {
    //                temp[t--] = array[end--];
    //            }
    //        }
    //
    //        while (start >= left) {
    //            temp[t--] = array[start--];
    //        }
    //        while (end > mid){
    //            temp[t--] = array[end--];
    //        }
    //        t = 0;
    //        while (left <= right){
    //            array[left++] = temp[t++];
    //        }
    //
    //    }
    //}
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //public static void Sort(int [] array) {
    //    int[] temp = new int[array.length];
    //    Sort(array,temp,0,array.length-1);
    //}
    //public static void Sort(int[] array, int[] temp, int left,int right) {
    //    if (left < right) {
    //        int mid = (left + right) / 2;
    //        Sort(array, temp, left, mid);
    //        Sort(array, temp, mid + 1, right);
    //        merge(array,  left, right,temp);
    //    }
    //}
    //public static void merge(int [] array, int [] temp, int left, int mid, int right) {
    //    int start = left, end = mid + 1,t = 0;
    //    while (start <= mid && end <= right) {
    //        if (array[start] < array[end]) {
    //            temp[t++] = array[start++];
    //        }else {
    //            temp[t++] = array[end++];
    //        }
    //    }
    //    while (start <= mid){
    //        temp[t++] = array[start++];
    //    }
    //    while (end <= right){
    //        temp[t++] = array[end++];
    //    }
    //      t = 0;
    //    while (left <= right){
    //        array[left++] = temp[t++];
    //    }
    //}
    //public static void merge(int [] array, int [] temp, int left, int right) {
    //    int mid = (left + right) / 2;
    //    int start = left, end = mid + 1,t = 0;
    //
    //    while (start <= mid && end <= right) {
    //        if (array[start] < array[end]) {
    //            temp[t++] = array[start++];
    //        }else {
    //            temp[t++] = array[end++];
    //        }
    //    }
    //    while (start <= mid){
    //        temp[t++] = array[start++];
    //    }
    //    while (end <= right){
    //        temp[t++] = array[end++];
    //    }
    //    t = 0;
    //    while (left <= right){
    //        array[left++] = temp[t++];
    //    }
    //}
    //
    //public static void merge(int [] array, int left, int right, int [] temp){
    //    int mid = (left + right) / 2;
    //    int start = mid  , end = right,t = right - left ;
    //    while (left <= start && mid  < end){
    //        if (array[start] > array[end]){
    //            count += (end - mid);
    //            temp[t--] = array[start--];
    //        }else {
    //            temp[t--] = array[end-- ];
    //        }
    //    }
    //
    //    while (left <= start){
    //        temp[t--] = array[start--];
    //    }
    //
    //    while (mid < end){
    //        temp[t--] = array[end--];
    //    }
    //    t = 0;
    //    while (left <= right){
    //        array[left++] = temp[t++];
    //    }
    //}


}
