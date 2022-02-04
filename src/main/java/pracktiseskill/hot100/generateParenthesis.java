package pracktiseskill.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName generateParenthesis
 * @Description
 * @Author liubo
 * @Date 2021/5/15 11:42 下午
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/

//todo 
public class generateParenthesis {
    //括号生成，用回溯法，回溯的方法主要需要一个中间增删的数据结构来变换不同的中间值

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        StringBuilder sb = new StringBuilder();
        Iterator<String> iterator = ans.iterator();
        return ans;
    }
    //关键在回溯方法的设计，哪个先进入，哪个后进入
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        //关键在回溯方法的设计
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<String>();
        StringBuilder temp = new StringBuilder();
        getResult(result,0,0,temp, n);
        return result;
    }

    public static void getResult(List<String> result,int open,int close,StringBuilder temp,int n){
        if(temp.length() == 2 * n){
            result.add(temp.toString());
            return;
        }
        if(open < n){
            temp.append('(');
            getResult(result,open+1,close,temp,n);
             temp.deleteCharAt(temp.length()-1);
        }

        if(close < open){
            temp.append(')');
            getResult(result,open,close+1,temp,n);
            temp.deleteCharAt(temp.length()-1);
        }
    }


}
