package leetcode.twopoint.slidingwindow;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/permutation-in-string/
 * @author: liubo
 * @date: 2022-06-04 12:25
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName checkInclusion567
 * @Description
 * @Author liubo
 * @Date 2022/6/4 12:25 PM
 **/
public class checkInclusion567 {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int left = 0, right = 0, len = 0;

        for (char t : s1.toCharArray()) {
            need.put(t, need.getOrDefault(t, 0) + 1);
        }
        while (right < s2.length()) {
            char c = s2.charAt(right);
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    len++;
                }
            }
            right++;
            while (right - left >= s1.length()) {

                char lChar = s2.charAt(left);
                if (len == need.size()) {
                    return true;
                }

                if (need.containsKey(lChar)) {
                    if (need.get(lChar).equals(window.get(lChar))) {
                        len--;
                    }
                    window.put(lChar, window.get(lChar) - 1);
                }
                left++;
            }
        }
        return false;
    }
}
