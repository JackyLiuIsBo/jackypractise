package pracktiseskill.SortAlogrithm;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


/**
 * @ClassName distribute
 * @Description
 * @Author liubo
 * @Date 2021/5/5 11:58 上午
 **/
public class distribute {

    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5};

        coinChange(nums,11);
    }
    static int coinChange1(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for(int coin : coins){

                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;

        for(int coin : coins){
            for(int i = 1; i <= amount; i++){
                if(i >= coin){
                   int temp = Math.min(dp[i],dp[i - coin] + 1);
                    dp[i] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        return dp[amount];
    }
    public static boolean isPowerOfThree(int n) {
        if(n < 1){
            return false;
        }
        if(n == 1){
            return true;
        }

        if (n % 3 != 0){
            return false;
        }

        return isPowerOfThree(n/3);
    }



}
