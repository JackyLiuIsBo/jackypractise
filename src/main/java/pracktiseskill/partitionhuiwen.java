package pracktiseskill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.security.jgss.GSSToken;

/**
 * @ClassName partitionhuiwen
 * @Description
 * @Author liubo
 * @Date 2021/5/5 7:59 下午
 **/
public class partitionhuiwen {
    public static void main(String[] args) {
        List<List<String>> aabaa = partition("aabaa");
        System.out.println(Arrays.toString(aabaa.toArray()));
    }

   private static  List<List<String>> partition(String str){
       List<List<String>> result = new ArrayList<>();
       List<String> element = new ArrayList<>();
       boolean[][] isHW = new boolean[str.length()][str.length()];
       for (int right = 0; right < str.length(); right++){
           for (int left = 0; left <= right; left++){
               isHW[left][right] = (str.charAt(right) == str.charAt(left) && (right - left <=2 || isHW[left+1][right-1]));
           }
       }

       dfs(result,element,str,0,isHW);
       return result;
    }

    private static void dfs(List<List<String>> result, List<String> element, String str, int pos, boolean[][] isHW) {
        if (pos == str.length()-1){
            result.add(new ArrayList<>(element));
            return;
        }

        for (int i = pos; i < str.length(); i++){
            if (isHW[pos][i]) {
                element.add(str.substring(pos, i + 1));
                dfs(result, element, str, i+1, isHW);
                element.remove(element.size() - 1);
            }
        }

    }
    int[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    public List<List<String>> partition1(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }














    //public static List<List<String>> partition(String s) {
    //
    //    boolean [][] isHuiWen = new boolean[s.length()][s.length()];
    //    for(int right = 0; right < s.length(); right++){
    //        for (int j = 0; j <= right;j++){
    //
    //            //最关键的一步
    //            isHuiWen[j][right] = (s.charAt(right) == s.charAt(j) && (right - j <= 2 || isHuiWen[j+1][right-1]));
    //        }
    //    }
    //    List<List<String>> result = new ArrayList<>();
    //    List<String> element = new ArrayList<>();
    //    dfs(isHuiWen,s,result,0,element);
    //    return result;
    //}
    //
    //private static void dfs(boolean[][] isHuiWen, String s, List<List<String>> result,int pos,List<String> element) {
    //    if (s.length() - 1 == pos){
    //        result.add(new ArrayList<>(element));
    //    }
    //
    //    for (int i = pos; i < s.length(); i++){
    //        if (isHuiWen[pos][i]) {
    //            element.add(s.substring(pos, i+1));
    //            dfs(isHuiWen,s,result,i+1,element);
    //            element.remove(element.size()-1);
    //        }
    //
    //    }
    //}
}
