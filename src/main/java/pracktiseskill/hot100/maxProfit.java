package pracktiseskill.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @ClassName maxProfit
 * @Description
 * @Author liubo
 * @Date 2021/5/17 7:49 下午
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1:
 *
 * 输入: prices = [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 **/
public class maxProfit {
    //利用二维数组的行表示天数，列表示当天是持股还是不持股。
    public int maxProfit (int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] num : dp){
            list.add(num[0],num);
        }
        int[][] ints = list.toArray(new int[prices.length][]);
        Integer[][] integers = list.toArray(new Integer[2][2]);

        Arrays.sort(dp,(int[]num1,int[]num2) ->{
            if (num1[0] > num2[0]){
                return num1[0] - num2[0];
            }else {
                return num1[1] - num2[1];
            }
        });

        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //Executors.newFixedThreadPool();
        //Executors.newCachedThreadPool();
        //Executors.newScheduledThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        for (int i = 1; i < length; i++){
            //如果今天持股，在昨天没卖股票和昨天卖了股票的情况中选最优的
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
            //如果今天不持股，在昨天没卖股票和昨天卖了股票的情况中选最优的
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
        }
        //最后一天一定是手里持有现金
        return dp[length-1][0];
    }
}
