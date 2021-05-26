package pracktiseskill.hot100;

/**
 * @ClassName maxProfit2
 * @Description
 * @Author liubo
 * @Date 2021/5/17 8:21 下午
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 **/
public class maxProfit2 {
    /**
     *     该题可以分为三种情况讨论，第一种情况为刚卖股票持有现金，用dp[i][1]表示，第二种情况表示持有股票dp[i][0],第三种情况表示dp[i][2]隔天就能买卖股票。
     *     最终的结果需要从dp[n-1][1],dp[n-1][2]
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i = 1; i < length; i++){
            //
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][1],dp[i-1][2]);
        }
        return Math.max(dp[length-1][1],dp[length-1][2]);
    }
    public int maxProfi1t(int[] prices) {
        int length = prices.length;
        int sale = 0, hold = -prices[0], cold = 0;

        for(int i = 1; i < length; i++){
            int  tempsale = hold + prices[i];
            int temphold = Math.max(hold,cold - prices[i]);
            int tempcold = Math.max(cold,sale);
            sale = tempsale;
            hold = temphold;
            cold = tempcold;
        }
        return Math.max(sale,cold);
    }
}
