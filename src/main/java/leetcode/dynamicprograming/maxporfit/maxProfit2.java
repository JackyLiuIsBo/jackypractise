package leetcode.dynamicprograming.maxporfit;/**
 * @program: jackypractise
 * @description:
 * @author: liubo
 * @date: 2022-03-22 01:51
 **/

import java.util.HashMap;
import java.util.Map;

/**
 @ClassName maxProfit2
 @Description122. 买卖股票的最佳时机 II
 给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。

 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
 返回 你能获得的 最大 利润 。



 示例 1:

 输入: prices = [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 示例 2:

 输入: prices = [1,2,3,4,5]
 输出: 4
 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 示例 3:

 输入: prices = [7,6,4,3,1]
 输出: 0
 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。


 提示：

 1 <= prices.length <= 3 * 104
 0 <= prices[i] <= 104

 @Author liubo
 @Date 2022/3/22 1:51 上午
 **/
public class maxProfit2 {

    public static void main(String[] args) {
        int[] nums = {0,1,5,4,2,4,7,2,3,0,3,0,0,9,7,5,9,4,3,9,9,2,1,6,3,1,0,7,6,6,6,0,1,7,1,9,4,9,3,3,4,5,0,3,8,7,1,8,4,5};
        minDeletion(nums);
    }

    public static int minDeletion(int[] nums) {
        int length = nums.length;
        int result = 0;
        int flag = 2;
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        if(nums[0] == nums[1]){
            result++;
            flag = 1;
        }
        Map<Integer,Integer> map = new HashMap();

        for(int i = 2; i < nums.length; i++,flag++){
            int count = 0;

            while(i < nums.length - 1 && nums[i] == nums[i+1]){
                count++;
                i++;
                flag++;
            }

            if((flag - count)  % 2 == 0 && count >= 1){
                result += count ;
                flag -= count;
            }
            if((flag - count)  % 2 == 1 && count >= 1){
                result += count - 1;
                flag -= count - 1;
            }
        }



        if((length - result) % 2 != 0){
            result++;
        }

        return result;

    }

    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices == null || prices.length == 1){
            return 0;
        }

        int temp = 0, result =0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prices[i-1] < 0){
                continue;
            }
            temp = Math.max(temp += prices[i] - prices[i-1], 0);
            result  = Math.max(result,temp);
        }
        return result;
    }
}
