package offer;


import java.util.Arrays;

public class InversePairs {
    public static int pairsnum = 0;

    public static void main(String[] args) {
        int[][] nums = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        int[][] merges = merges(nums);
    }

    public static int[][] merges(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals,(o1,o2) ->  o1[0] - o2[0]);
        int count = -1;
        int[][] result = new int[intervals.length][2];
        for(int [] interval : intervals){
            if(count == -1 || interval[0] > result[count][1]){
                result[++count] = interval;
            }else{
                result[count][1] = Math.max(interval[1],intervals[count][1]);
            }

        }
        return Arrays.copyOf(result,count+1);
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals,(o1, o2) ->  o1[0] - o2[0]);
        int count = -1;
        int[][] result = new int[intervals.length][2];
        for(int [] interval : intervals){
            if(count == -1 || interval[0] > intervals[count][1]){
                result[++count] = interval;
            }else{
                result[count][1] = Math.max(interval[1],intervals[count][1]);
            }

        }
        return Arrays.copyOf(result,count+1);
    }


    public static int InversePairs(int [] array) {
            int [] temp = new int[array.length];
        int n = mergeSort(array, temp, 0, array.length - 1);
        System.out.println(n);
        return n;
    }

    public static int mergeSort(int[] array,int []temp, int left,int right){
        if (left == right) {
            return 0;
        }
        int  mid = (left + right) / 2;
        mergeSort(array,temp,left,mid);
        mergeSort(array,temp,mid+1,right);
        return merge(array,temp,left,mid,right);
    }
    public static int merge(int[] array,int []temp, int left,int mid,int right){
        int count = 0;
        int i = mid,j = right;
        while (i >= left && j >= mid+1){
            if (array[i] > array[j]){
                pairsnum += j - mid;
                temp[count++] = array[i--];
            }else {
                temp[count++] = array[j--];
            }
        }
        while (i >=left){
            temp[count++] = array[i--];
        }
        while (j >= mid+1){
            temp[count++] = array[j--];
        }
        while (left <= right){
            array[left++] = temp[--count];
        }
        return pairsnum;
    }

}
