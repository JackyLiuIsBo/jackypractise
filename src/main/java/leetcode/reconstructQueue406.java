package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName reconstructQueue406
 * @Description
 * @Author eleme
 * @Date 2020/12/15 12:48 上午
 **/
public class reconstructQueue406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(t1,t2) ->{
                if(t1[0] != t2[0]){
                    return t2[0] - t1[0];
                }else{
                    return t1[1] - t2[1];
                }
            }
        );
        ArrayList<int []> result = new ArrayList();
        for(int [] temp : people){
            result.add(temp[1],temp);
        }
        return   result.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "a" + "b";
        System.out.println(s1.equals(s2));
    }
}
