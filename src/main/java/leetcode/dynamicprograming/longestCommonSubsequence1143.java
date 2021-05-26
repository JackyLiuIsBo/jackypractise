package leetcode.dynamicprograming;

/**
 * @ClassName longestCommonSubsequence
 * @Description
 * @Author eleme
 * @Date 2020/12/13 4:12 下午
 **/
public class longestCommonSubsequence1143 {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        int i = longestCommonSubsequence(s1, s2);

    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int [text1.length() + 1][text2.length() + 1];
        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                char t1 = text1.charAt(i-1), t2 = text1.charAt(j-1);

                if(t1 == t2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
