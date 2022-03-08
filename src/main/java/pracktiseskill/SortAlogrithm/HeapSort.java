package pracktiseskill.SortAlogrithm;

import java.util.Arrays;

public class HeapSort {
    private static int count = 0;

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 5, 6, 7, 0};
        qSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    static void mergeSort(int[] nums,int left,int right) {
        int mid = (left + right) / 2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        int [] temp = new int[nums.length];

    }

    private static void merge(int[] nums, int left, int right, int[] temp) {


    }






    static void qSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int partion = partions(nums, left, right);
        qSort(nums, left, partion - 1);
        qSort(nums, partion + 1, nums.length - 1);
    }

    private static int partions(int[] nums, int left, int right) {

        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] > temp) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;

        return left;
    }

    public void heap(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            makeHeap(nums, i, nums.length - 1);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            makeHeap(nums, 0, i - 1);
        }
    }

    public void makeHeap(int[] nums, int pos, int length) {
        int child = 0, temp = nums[pos];

        for (; pos * 2 + 1 <= length; pos = child) {
            child = pos * 2 + 1;

            if (child < length && nums[child] < nums[child + 1]) {
                child++;
            }

            if (nums[child] > temp) {
                nums[pos] = nums[child];
            } else {
                break;
            }
        }
        nums[pos] = temp;

    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pos = partion(array, left, right);
            quickSort(array, left, pos);
            quickSort(array, pos + 1, right);
        }
    }

    private static int partion(int[] array, int left, int right) {

        int temp = array[left];
        while (right > left) {
            while (right > left && array[right] > temp) {
                right--;
            }
            array[left] = array[right];
            while (right > left && array[left] <= temp) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = temp;
        return left;
    }

    private static void heapSorts(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjust(array, i, array.length - 1);
        }

        for (int i = array.length - 1; i >= 0; i--) {
            swap(array, i, 0);
            adjust(array, 0, i - 1);
        }
    }

    private static void adjust(int[] array, int pos, int length) {
        int child = 0, temp = array[pos];

        for (; pos * 2 + 1 <= length; pos = child) {
            child = pos * 2 + 1;

            if (child + 1 <= length && array[child + 1] > array[child]) {
                child++;
            }

            if (array[child] > temp) {
                array[pos] = array[child];
            } else {
                break;
            }
        }
        array[pos] = temp;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    //public static void heapSort(int[] array){
    //    for(int i = array.length / 2 - 1; i >= 0; i--){
    //        adjust(array,i,array.length-1);
    //    }
    //
    //    for(int i = array.length - 1; i >=0; i--){
    //        int temp = array[i];
    //        array[i] = array[0];
    //        array[0]  = temp;
    //
    //
    //        adjust(array,0,i-1);
    //
    //    }
    //
    //}
    //
    //public static void adjust(int [] array,int pos,int length){
    //    int chirld = pos,temp = array[pos];
    //    for(; pos * 2 + 1 <= length; pos = chirld){
    //        chirld = pos * 2 + 1;
    //        if(chirld < length && array[chirld] < array[chirld + 1]){
    //            chirld++;
    //        }
    //
    //        if(array[chirld] > temp){
    //            array[pos] = array[chirld];
    //        }else {
    //            break;
    //        }
    //    }
    //
    //
    //    array[pos] = temp;
    //
    //
    //}

    //
    //private static void heapSort(int [] array){
    //    for(int i = array.length / 2 - 1; i >= 0; i--){
    //        adjust(array,i,array.length - 1);
    //    }
    //
    //    for(int i = array.length - 1; i >= 0; i--){
    //        int temp = array[i];
    //        array[i] = array[0];
    //        array[0] = temp;
    //        adjust(array,0,i - 1);
    //    }
    //}
    //
    //private static void adjust(int [] array, int pos, int length){
    //    int temp = array[pos],child = 1;
    //
    //    for(;pos * 2 + 1 <= length; pos = child){
    //        child = 2 * pos + 1;
    //
    //        if(child < length && array[child] < array[child + 1]){
    //            child++;
    //        }
    //
    //        if(temp < array[child]){
    //            array[pos] = array[child];
    //        }else{
    //            break;
    //        }
    //
    //    }
    //
    //    array[pos] = temp;
    //
    //}

    //private static void heapSort(int[] array) {
    //    for (int i = array.length / 2 -1 ; i >= 0; i--){
    //        adjust(i,array.length-1,array);
    //    }
    //
    //    for (int i = array.length-1; i >= 0; i--){
    //        int temp = array[0];
    //        array[0] = array[i];
    //        array[i] = temp;
    //        adjust(0,i-1,array);
    //    }
    //}
    //
    //private static void adjust(int start, int end, int[] array) {
    //    int temp = array[start],child = 0;
    //    for (;start * 2 + 1 <= end; start = child){
    //        child = start * 2 + 1;
    //        if (child < end && array[child] < array[child + 1]){
    //            child++;
    //        }
    //        if (array[start] < array[child]){
    //            array[start] = array[child];
    //        }else {
    //            break;
    //        }
    //    }
    //    array[start] = temp;
    //}

}
