package leetcode.twopoint.slidingwindow;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * @author: liubo
 * @date: 2022-06-03 23:50
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName findAnagrams438
 * @Description
 * @Author liubo
 * @Date 2022/6/3 11:50 PM
 **/
public class findAnagrams438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";

        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(Arrays.toString(anagrams.toArray()));
    }

    private static List<Integer> findAnagrams(String s, String p) {
            Map<Character,Integer> window = new HashMap<>();
            Map<Character,Integer> need = new HashMap<>();
            List<Integer> result = new ArrayList<>();
            int left = 0,right = 0,len = 0;
            for (char c : p.toCharArray()){
                need.put(c,need.getOrDefault(c,0) + 1);
            }
            while (right < s.length()){
                char c = s.charAt(right);
                right++;
                if (need.containsKey(c)){
                    window.put(c,window.getOrDefault(c,0) + 1);
                    if (need.get(c).equals(window.get(c))){
                        len++;
                    }
                }

                while (right - left >= p.length()){
                    if (len == need.size()){
                        result.add(left);
                    }
                    char lChar = s.charAt(left);
                    left++;
                    if (need.containsKey(lChar)){
                        if (need.get(lChar).equals(window.get(lChar))){
                            len--;
                        }
                        window.put(lChar,window.get(lChar) - 1);
                    }
                }
            }

            return result;

    }

    //
    //public static List<Integer> findAnagrams(String s, String p) {
    //    Map<Character,Integer> window = new HashMap<>();
    //    Map<Character,Integer> needs = new HashMap<>();
    //
    //    int left = 0, right = 0, len = 0;
    //    List<Integer> result = new ArrayList<>();
    //    for (char c : p.toCharArray()) {
    //        needs.put(c,needs.getOrDefault(c,0)+ 1);
    //    }
    //    while (right < s.length()) {
    //        char c = s.charAt(right);
    //        right++;
    //        if (needs.containsKey(c)) {
    //            window.put(c,window.getOrDefault(c,0) + 1);
    //            if (window.get(c).equals(needs.get(c))){
    //                len++;
    //            }
    //        }
    //        while (right - left >= p.length()) {
    //            if (len == needs.size()){
    //                result.add(left);
    //            }
    //
    //            char lC = s.charAt(left);
    //            left++;
    //            if (needs.containsKey(lC)) {
    //                if (window.get(lC).equals(needs.get(lC))){
    //                    len--;
    //                }
    //                window.put(lC,window.get(lC) - 1);
    //            }
    //        }
    //    }
    //    return result;
    //}
}
