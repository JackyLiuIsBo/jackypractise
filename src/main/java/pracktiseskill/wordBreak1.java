package pracktiseskill;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName wordBreak1
 * @Description
 * @Author liubo
 * @Date 2021/5/6 1:08 上午
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions/xa503c/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 **/
public class wordBreak1 {
    public static void main(String[] args) {
        String s = "leetcode";
        ArrayList<String> wordDict = new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean b = wordBreak(s, wordDict);
        System.out.println(b);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()+1];
        dp[0] = true;
        for (int right = 1; right <= s.length(); right++){
            for (int left = 0; left < right; left++){
                dp[right] = dp[left] && set.contains(s.substring(left,right));
                if (dp[left] && set.contains(s.substring(left,right))){
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
