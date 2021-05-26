package pracktiseskill.dynamic;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName countSmaller
 * @Description
 * @Author liubo
 * @Date 2021/5/13 11:52 下午\你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class countSmaller {
    public int longestSubstring(String s, int k) {

        if(s.length() < k){
            return 0;
        }

        HashMap<Character,Integer> map = new HashMap(100);

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }

        for(char a : map.keySet()){
            //如果当前字符的个数小于k,这任何包含这个字符的子串都不符合要求
            if (map.get(a) < k){
                String[] split = s.split(String.valueOf(a));
                int result = 0;
                for(String temp : split){
                    result =  Math.max(result,longestSubstring(temp,k));
                }
                return result;
            }
        }
        return s.length();

    }
    public int longestSubstring1(String s, int k) {
        if (s.length() < k) return 0;
        HashMap<Character, Integer> counter = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            counter.put(s.charAt(i), counter.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                int res = 0;
                for (String t : s.split(String.valueOf(c))) {
                    res = Math.max(res, longestSubstring1(t, k));
                }
                return res;
            }
        }
        return s.length();
    }

}
