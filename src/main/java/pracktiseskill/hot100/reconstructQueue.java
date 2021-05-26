package pracktiseskill.hot100;

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
    public int[][] reconstructQueue(int[][] people) {
        //关键在于没有提示的情况下，这个也能手写出来
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<int[]>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
