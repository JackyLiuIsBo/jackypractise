package offer.sort;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName largestNumber
 * @Description
 * @Author liubo
 * @Date 2021/5/11 12:54 上午
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 *
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出："1"
 * 示例 4：
 *
 * 输入：nums = [10]
 * 输出："10"
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa1401/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class largestNumber {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();

        map.put(null,null);
    }
    public String largestNumber(int[] nums) {
        String[] temp = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            temp[i] = nums[i] + "";
        }
        Arrays.sort(temp,(a,b)->{
            return (b + a).compareTo(a + b);
        });
        String result = "";

        for(String t : temp){
            result += t;
        }
        int k = 0;
        while(result.charAt(k) == '0' && k < result.length() -1 ){
            k++;
        }

        return result.substring(k);
    }
}
