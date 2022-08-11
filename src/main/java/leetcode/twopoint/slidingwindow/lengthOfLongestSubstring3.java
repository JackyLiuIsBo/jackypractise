package leetcode.twopoint.slidingwindow;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @author: liubo
 * @date: 2022-06-04 16:35
 **/

import java.util.HashMap;
import java.util.Map;

/**
 @ClassName lengthOfLongestSubstring3
 @Description
 @Author liubo
 @Date 2022/6/4 4:35 PM
 **/
public class lengthOfLongestSubstring3 {
    public static void main(String[] args) {
        String s = "aab";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
     //   Map<Character,Integer> need = new HashMap<>();
        int left = 0,right = 0,len = 0;
        //for (char c : s.toCharArray()){
        //    need.put(c,need.getOrDefault(c,0) + 1);
        //}
        while (right < s.length()){
            //move the right point

            char c = s.charAt(right);
            window.put(c,window.getOrDefault(c,0) + 1);
            right++;

            while (window.get(c) > 1 ){


                char lChar = s.charAt(left);
                window.put(lChar,window.get(lChar) - 1);
                left++;

            }
            len = Math.max(len,right - left);
        }
        if (left == 0){
            len = right;
        }
        return len;

    }
}
