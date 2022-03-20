package leetcode.dynamicprograming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 求{1,4,9,16--}等数组成的最小个数
 * 如 17 = 16 + 1； 3 = 1+1+1
 */
public class numSquares {
    public static void main(String[] args) {
        int i = numSquares(17);
        System.out.println(i);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>(hashSet);
    }
    public static int numSquares(int n){
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }
}
