package leetcode.chineseversion;

import com.alibaba.fastjson.JSON;

/**
 * @ClassName Solution338
 * @Description
 * @Author liubo
 * @Date 2020/11/2 8:37 下午
 **/
public class Solution338 {
    public static int[] countBits(int num) {
        int [] count = new int[num+1];
        for(int i = 0; i <= num ; i++ ){
            count[i] = count(i);
        }
        return count;
    }

    public static int count(int num){
        int count = 0;
        while(num > 0){
            if((num & 1) == 1){
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

    public static void main(String[] args) {

        int[] ints = countBits(5);
        System.out.println(JSON.toJSONString(ints));
    }
}
