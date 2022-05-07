package leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName reconstructQueue
 * @Description
 * @Author liubo
 * @Date 2021/5/16 12:14 下午
 **/

//todo
public class reconstructQueue {
    public static void main(String[] args) {
        int [][] nums = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        reconstructQueue(nums);
    }
    public static int[][] reconstructQueue(int[][] people) {
        //关键在于没有提示的情况下，这个也能手写出来
       Arrays.sort(people,(int[]o1,int[]o2)->{
           if (o1[0] != o2[0]){
               return o2[0] - o1[0];
           }else {
               return o1[1] - o2[1];
           }
       });
       List<int[]> list = new ArrayList<>();
       for (int[] temp : people){
           list.add(temp[1],temp);
       }
       return list.toArray(new int[list.size()][2]);
    }

}
