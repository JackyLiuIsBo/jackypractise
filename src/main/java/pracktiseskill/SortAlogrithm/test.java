package pracktiseskill.SortAlogrithm;

import java.util.HashSet;

/**
 * @ClassName test
 * @Description
 * @Author liubo
 * @Date 2021/5/14 1:21 上午
 **/
public class test {
    static int count = 0;

    public static void main(String[] args) {
        int[] array = {1,2,3,5,4,7,6,0};;
        sort(array);
        for (int i:array
        ) {
            System.out.println(i);
        }
        HashSet<Integer> set = new HashSet<>();
        System.out.println("count :"+count);
    }
    public static void sort(int [] array){
        quickSort(array,0,array.length-1);
    }

    public static void quickSort(int[] array,int left,int right){
        if(left >= right){
            return ;
        }
        int pos = partion(array,left,right);
        quickSort(array,left,pos-1);
        quickSort(array,pos+1,right);
    }

    public static int partion(int [] array,int left,int right){
        int temp = array[left],start = left, end = right;

        while(start < end){
            while(start < end && array[end] >= temp){
                end--;
            }
            array[start] = array[end];
            while(start < end && array[start] < temp){
                start++;
            }
            array[end] = array[start];
        }
        array[end] = temp;
        return start;
    }
}
