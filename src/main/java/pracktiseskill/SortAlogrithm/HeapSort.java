package pracktiseskill.SortAlogrithm;

import java.util.Arrays;
import java.util.Stack;

public class HeapSort {
    private static int count = 0;
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String temp : tokens){
            if(isNumber(temp)){
                stack.push(new Integer(temp));
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(temp){
                    case "+" : stack.push(num2 + num2); break;
                    case "-" : stack.push(num1 - num2); break;
                    case "/" : stack.push(num1 / num2); break;
                    case "*" : stack.push(num1 * num2); break;
                    default :
                }
            }

        }
        return stack.pop();
    }
    private static boolean isNumber(String str){
        return !(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
    public static void main(String[] args) {
        String [] tokens = {"4","13","5","/","+"
};
        int num = evalRPN(tokens);
        System.out.printf(num + "");

//        int[] array = {1, 2, 3, 4, 5, 6, 7, 0};
//       // quickSort(array,0,array.length-1);
//        heapSort(array);
//        double du = 1;
//        int num = (int) du;
//        du = num;
//        Stack<Integer> stack = new Stack();
//        Integer integer = new Integer("1");
//        stack.stream().mapToInt(Integer::valueOf);
//
//        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int [] nums){
        for(int i = nums.length / 2 - 1; i >= 0; i--){
            makeHeap(nums,i,nums.length-1);
        }

        for (int i = nums.length - 1; i >= 0; i--){
            swap(nums,i,0);
            makeHeap(nums,0,i-1);
        }
    }

    private static void makeHeap(int[] nums,int pos,int length){
        int child = pos,temp = nums[pos];
        for(; pos * 2 + 1 <= length; pos = child){
            child = pos * 2 + 1;
            if (child < length && nums[child] < nums[child + 1]){
                child++;
            }
            if (temp < nums[child]){
                nums[pos] = nums[child];
            }else {

                break;
            }
        }
        nums[pos] = temp;
    }





    private static void heapSorts(int[] array){
        for(int i = array.length / 2 - 1; i >= 0; i--){
            adjust(array,i,array.length-1);
        }

        for(int i = array.length - 1; i >= 0; i--){
            swap(array,i,0);
            adjust(array,0,i-1);
        }
    }

    private static void adjust(int[] array,int pos,int length){
        int child = 0, temp = array[pos];

        for(; pos * 2 + 1 <= length; pos = child){
            child = pos * 2 + 1;

            if(child + 1 <= length && array[child+1] > array[child]){
                child++;
            }

            if (array[child] > temp){
                array[pos] = array[child];
            }else {
                break;
            }
        }
        array[pos] = temp;
    }




    private static void sortMerge(int[] array) {
        int [] temp = new int[array.length];
        mergerSorts(array,0,array.length-1,temp);
    }

    private static void mergerSorts(int[] array,int left,int right,int [] temp){
        if (left < right){
            int mid = (left + right) / 2;

            mergerSorts(array,left,mid,temp);
            mergerSorts(array,mid+1,right,temp);

            int start = mid, end = right, t = right - left;

            while (start >= left && end > mid){

                if(array[start] < array[end]){
                    temp[t--] = array[end--];
                }else {
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


























    //
    //private static void sort(int [] array,int left ,int right, int [] temp){
    //    if (left < right){
    //        int mid = (left + right) / 2;
    //        int start = mid,end = right,t = right - left;
    //
    //        sort(array,left,mid,temp);
    //
    //        sort(array,mid+1,right,temp);
    //
    //        while (start >= left && end > mid){
    //            if (array[start] > array[end]){
    //                temp[t--] = array[start--];
    //                count += end - mid;
    //            }else {
    //                temp[t--] = array[end--];
    //            }
    //        }
    //
    //        while (start >= left){
    //            temp[t--] = array[start--];
    //        }
    //        while (end > mid){
    //            temp[t--] = array[end--];
    //        }
    //        t = 0;
    //        while (left <= right){
    //            array[left++] = temp[t++];
    //        }
    //    }
    //}




    private static void swap(int [] array,int a, int b){
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
