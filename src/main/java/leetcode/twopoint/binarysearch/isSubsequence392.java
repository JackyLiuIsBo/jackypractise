package leetcode.twopoint.binarysearch;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/is-subsequence/
 * @author: liubo
 * @date: 2022-06-01 23:12
 **/

/**
 @ClassName isSubsequence392
 @Description
 @Author liubo
 @Date 2022/6/1 11:12 PM
 **/
public class isSubsequence392 {
    public static void main(String[] args) {
       String  s = "abc", t = "ahbgdc";
        boolean subsequence = isSubsequence(s, t);
        System.out.println(subsequence);
    }
    public static boolean isSubsequence(String s, String t) {
        int pT = 0,pS = 0;
        while (pT < t.length() && pS < s.length() ){
            if (t.charAt(pT) == s.charAt(pS)){
                pS++;
            }
            pT++;

        }

        return pS == s.length() ;
    }
}
