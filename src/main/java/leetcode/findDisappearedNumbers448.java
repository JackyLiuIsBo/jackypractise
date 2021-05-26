package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName findDisappearedNumbers448
 * @Description
 * @Author eleme
 * @Date 2020/12/28 8:48 下午
 **/
public class findDisappearedNumbers448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int temp = 0;
            if (nums[i] < 0){
                temp = -nums[i];
            }else {
                temp = nums[i];
            }
            if (nums[temp-1] < 0){
                continue;
            }
            nums[temp-1] = -nums[temp-1];
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                list.add(i+1);
            }
        }
       list.forEach(t ->{
           System.out.println(t);
       });
        return list;
    }

    public static void main(String[] args) {

    }

}
