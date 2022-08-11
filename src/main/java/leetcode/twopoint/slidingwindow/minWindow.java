package leetcode.twopoint.slidingwindow;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/minimum-window-substring/
 * @author: liubo
 * @date: 2022-06-03 19:39
 **/

import java.util.HashMap;
import java.util.Map;

/**
 @ClassName minWindow
 @Description
 @Author liubo
 @Date 2022/6/3 7:39 PM
 **/
public class minWindow {
    public static void main(String[] args) {
        String s = "a", t = "aa";
        String sub = minWindow(s, t);
        System.out.println(sub);
    }

    public static String minWindow(String s, String t) {
        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (Character c:t.toCharArray()
             ) {
            needs.put(c,needs.getOrDefault(c,0) + 1);
        }
        int right = 0,left = 0,index = 0,start = 0,len = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)){
                window.put(c,window.getOrDefault(c,0) + 1);
                if (window.get(c).equals(needs.get(c))){
                    index++;
                }
            }
            while (index == needs.size()){
                if (len > right - left){
                    len = right - left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                left++;
                if (needs.containsKey(leftChar)){
                    if (window.get(leftChar).equals(needs.get(leftChar))) {
                        index--;
                    }
                    window.put(leftChar,window.get(leftChar) - 1);

                }
            }
        }
        return len == Integer.MAX_VALUE ? "" :s.substring(start,start + len);
    }
    //    Map<Character,Integer> windows = new HashMap<>();
    //    Map<Character,Integer> needs = new HashMap<>();
    //    int valid = 0,left = 0,right = 0,start = 0,len = Integer.MAX_VALUE;
    //    for (Character c : t.toCharArray()){
    //        needs.put(c, needs.getOrDefault(c,0)  + 1);
    //    }
    //    int index = 0;
    //    while (right < s.length()){
    //        char c = s.charAt(right);
    //        right++;
    //        if (needs.containsKey(c)){
    //            windows.put(c,windows.getOrDefault(c,0) + 1);
    //            if (windows.get(c).equals(needs.get(c))) {
    //                index++;
    //            }
    //        }
    //        while (index == needs.size()){
    //            if (right - left < len){
    //                start = left;
    //                len = right - left;
    //            }
    //            char leftC = s.charAt(left);
    //            left++;
    //            if (needs.containsKey(leftC)){
    //                if (needs.get(leftC).equals(windows.get(leftC))) {
    //                    index--;
    //                }
    //                windows.put(leftC,windows.get(leftC) - 1);
    //            }
    //        }
    //    }
    //    return len == Integer.MAX_VALUE ? "" : s.substring(start,len + start) ;
    //
    //}
}
