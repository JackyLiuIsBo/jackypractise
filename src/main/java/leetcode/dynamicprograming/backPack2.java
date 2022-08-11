package leetcode.dynamicprograming;

public class backPack2 {
    public static int knapSack(int[] w, int[] v, int C) {
        int size = w.length;
        if (size == 0) {
            return 0;
        }

        int[][] dp = new int[size][C + 1];
        //初始化第一行
        //仅考虑容量为C的背包放第0个物品的情况
        for (int i = 0; i <= C; i++) {
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }
        //填充其他行和列
        for (int i = 1; i < size; i++) {
            for (int j = C; j >= w[i]; j--) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }
        return dp[size - 1][C];
    }

    public static void main(String[] args) {
        int[] w = { 1, 3, 2};
        int[] v = { 30, 20, 30};
        System.out.println(knapSack(w, v, 5));
    }


//    private static int backPack2(int[] w,int[] v,int contain){
//
//        for ()
//    }

    private static int backpack(int[] w,int[] v,int contain){
        int[][] dp = new int[w.length][contain+1];
        for(int i = 0; i < contain; i++){
            dp[0][i] = w[0] <= i ? v[0] : 0;
        }

        for(int i = 1; i < w.length; i++){
            for(int j = 0; j <= contain; j++){
                dp[i][j] = dp[i - 1][j];
                if (w[i] <= j){
                    dp[i][j] = Math.max(dp[i-1][j-w[i]] + v[i],dp[i][j]);
                }
            }
        }
        return dp[w.length-1][contain];
    }
    //price表示商品的价格，n表示商品的个数
//    private static int getRetail(int[] items,int n,int condition){
//        int[][] dp = new int[n][condition+1];
//
//    }
}


