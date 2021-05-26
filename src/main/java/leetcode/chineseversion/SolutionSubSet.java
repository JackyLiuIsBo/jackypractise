package leetcode.chineseversion;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName SolutionSubSet
 * @Description
 * @Author liubo
 * @Date 2020/11/2 5:56 下午
 **/
public class SolutionSubSet {


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i <= size; i++ ){
            getSubSet(i,0,result,list,nums);
        }
        return result;
    }

    private static void getSubSet(int size, int start, List<List<Integer>> result, List<Integer> list,int[] nums) {

        if (list.size() == size){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length;i ++){
            list.add(nums[i]);
            getSubSet(size,i+1,result,list,nums);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(JSON.toJSONString(subsets));
    }

}
