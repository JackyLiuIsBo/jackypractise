package pracktiseskill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName subsets
 * @Description
 * @Author liubo
 * @Date 2021/5/5 8:41 下午
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 求全排列和子集有所不同，全排列需要对当前的位置进行交换，下一步迭代需要对当前位置+1，而求子集则是对for循环的变量i 进行 +1 操作
 **/
public class subsets {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(Arrays.toString(subsets.toArray()));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> element = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permutation(element,result,nums,0);
        return result;
    }

    private static void permutation(List<Integer> element, List<List<Integer>> result, int[] nums, int pos) {

        result.add(new ArrayList<>(element));
        for (int i = pos; i < nums.length;i ++){
            element.add(nums[i]);
            permutation(element,result,nums,i+1);
            element.remove(element.size()-1);
        }
    }
}
