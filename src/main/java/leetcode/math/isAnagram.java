package leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-anagram/
 */
public class isAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                map.put(c,map.get(c) - 1);
            }else {
                return false;
            }
        }
        for (Map.Entry<Character,Integer> entry: map.entrySet()){
            if (entry.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
