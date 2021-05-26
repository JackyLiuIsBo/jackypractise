package pracktiseskill.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName findAnagrams
 * @Description
 * @Author liubo
 * @Date 2021/5/22 1:09 上午
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 **/
public class findAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()){
           return   result;
        }
        int[] sIndex = new int[26];
        int[] pIndex = new int[26];
        int length = p.length();
        for(int i = 0; i < length;i++){
            sIndex[s.charAt(i) - 'a']++;
            pIndex[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(sIndex,pIndex)){
            result.add(0);
        }

        for(int i = length; i < s.length(); i++){
            sIndex[s.charAt(i-length) - 'a']--;
            sIndex[s.charAt(i) - 'a']++;
            if (Arrays.equals(sIndex,pIndex)){
                result.add(i);
            }
        }
        return result;

    }
}
