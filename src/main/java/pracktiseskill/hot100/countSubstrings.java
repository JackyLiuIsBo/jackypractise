package pracktiseskill.hot100;

/**
 * @ClassName countSubstrings
 * @Description
 * @Author liubo
 * @Date 2021/5/16 10:54 下午
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 **/
public class countSubstrings {
    public static void main(String[] args) {
        String str = "abaaa";
        int i = countSubstrings(str);
        System.out.println(i);

    }

    //求回文子串是用中心扩展算法，
    public static int countSubstrings(String s) {
        int sum = 0;
        int length = s.length();
        //这里i的范围需要扩展一倍
        for (int i = 0; i < 2 * length - 1; i++) {
            int left = i / 2;
            int right = i / 2 + i % 2;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                sum++;
            }
        }
        return sum;
    }

}
