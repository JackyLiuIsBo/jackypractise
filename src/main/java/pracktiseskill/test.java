package pracktiseskill;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import javax.persistence.criteria.CriteriaBuilder.In;

/**
 * @ClassName test
 * @Description
 * @Author liubo
 * @Date 2021/5/16 11:37 上午
 **/
public class test {
    public static void main(String[] args) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
             //   if (o2[0] != o1[0]) {
                    return o1[1] - o2[1];

            }
        });

        int [][] temp = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] != o1[0]){
                    return o2[0] - o1[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        List<int[]> list = new LinkedList<>();
        for (int[]t : temp){
            list.add(t[1],t);
        }
        for(int i = 0; i < list.size(); i++){
            temp[i] = list.get(i);
        }

        System.out.println(Arrays.toString(list.toArray()));


    }



}
