package leetcode.chineseversion;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName Solution22
 * @Description
 * @Author liubo
 * @Date 2020/11/2 6:40 下午
 **/
public class Solution22 {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int left = 0,right = 0;
        StringBuilder temp = new StringBuilder();
        getResult(left,right,n,result,temp);
        return result;
    }

    private static void getResult(int left,int right,int n, List<String> result,StringBuilder temp) {

        if (left == n && right == left){
            result.add(temp.toString());
            return;
        }
        if (left < n){

            temp.append("(");
            getResult(left+1,right,n,result,temp);
            temp.deleteCharAt(temp.length()-1);
        }

        if (right < left){
            temp.append(")");
            getResult(left,right+1,n,result,temp);
            temp.deleteCharAt(temp.length()-1);
        }

    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(JSON.toJSONString(list));
    }
}
