package pracktiseskill.SortAlogrithm;

import static java.util.stream.Collectors.reducing;

public class quickSort {
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 5, 6, 9, 1};
        quickSort(array, 0, array.length - 1);
        int[] temp = {4,5,1,6,2,7,3,8};
        //ArrayList<Integer> integers = GetLeastNumbers_Solution(temp, 10);
        //System.out.println(integers.toString());;
        for (Integer t:array
             ) {
            System.out.println(t);
        }
    }

    private static void quickSort(int[] array,int left,int right){
        int pos = merge(array,left,right);
    }

    private static int merge(int[] array, int left, int right) {
        int temp = array[left];

        while (left < right){
            while (array[left] < temp  && left < right){
                left++;
            }
            while (array[right] > temp && left < right){
                right--;
            }
        }
        return 0;
    }

    //
   //
   //private static void quickSort(int[] array,int left,int right){
   //     if (left < right){
   //        int pos = partion(array,left,right);
   //        quickSort(array,left,pos);
   //        quickSort(array,pos+1,right);
   //     }
   //     return;
   //}
   //
   //private static int partion(int [] array,int left,int right){
   //     int temp = array[left],start = left,end = right;
   //     while (start < end){
   //         while (start < end && array[end] > temp){
   //             end--;
   //         }
   //         array[start] = array[end];
   //         while (start < end && array[start] <= temp){
   //             start++;
   //         }
   //         array[end] = array[start];
   //     }
   //     array[start] = temp;
   //     return start;
   //}











    //public static void quickSort(int [] array,int left,int right){
    //
    //    if(left < right){
    //
    //        int pos = partion(array,left,right);
    //
    //        quickSort(array,left,pos - 1);
    //        quickSort(array,pos + 1, right);
    //    }
    //
    //}
    //
    //
    //public static int partion(int [] array,int left,int right){
    //
    //    int temp = array[left];
    //
    //    while(left < right){
    //        while(left < right && temp < array[right]){
    //            right--;
    //        }
    //        array[left] = array[right];
    //        while(left < right && temp > array[left]){
    //            left++;
    //        }
    //        array[right] = array[left];
    //    }
    //
    //    array[left] = temp;
    //
    //
    //    return left;
    //
    //}








    //public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    //    ArrayList<Integer> results = new ArrayList<>();
    //    if (k > input.length) {
    //        for(int i:input){
    //            results.add(i);
    //        }
    //        return results;
    //    }
    //    if (k <= 0) {
    //        return results;
    //    }
    //    int pivit = 0, left = 0, right = input.length - 1;
    //    while (pivit != k - 1) {
    //
    //        if (pivit > k - 1){
    //           pivit = partion(input,left,pivit - 1);
    //        }else if (pivit < k - 1){
    //           pivit =  partion(input,pivit + 1,right);
    //        }
    //    }
    //    for (int i = 0; i < k ; i++){
    //        results.add(input[i]);
    //        System.out.println(input[i]);
    //    }
    //    return results;
    //}

}
