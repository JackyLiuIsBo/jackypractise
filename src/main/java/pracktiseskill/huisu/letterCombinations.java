package pracktiseskill.huisu;/**
 * @program: jackypractise
 * @description:给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: liubo
 * @date: 2022-02-12 20:55
 **/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import utils.utils.Md5Util;

/**
 @ClassName letterCombinations
 @Description
 @Author liubo
 @Date 2022/2/12 下午8:55
 **/
public class letterCombinations {

    //public static void main(String[] args) {
    //    List<String> list = letterCombinations("23");
    //    list.forEach(t ->{
    //        System.out.println(t);
    //    });
    //}

    public static void main(String[] args) {
        String s = generatePk(1006001L, 24009L);
        System.out.println(s.equals("0a6f145ebb5d8ce2d35a7c7852648699"));
        System.out.println(s);
    }
    private static String generatePk(Long userId, Long creativeId) {
        return Md5Util.md5(userId + "-" + creativeId);
    }
    public static List<String> letterCombinations(String digits) {
        List<String> combinations = Lists.newArrayList();
        if (digits.length() == 0){
            return combinations;
        }
        HashMap<Character,String> map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        backtrackss(map,combinations,new StringBuilder(),0,digits);
        return combinations;
    }
    private static void backtrackss(HashMap<Character, String> map, List<String> combinations,
        StringBuilder combination, int index, String digits) {
        if (index == digits.length()){
            combinations.add(combination.toString());
        }else {
            char c = digits.charAt(index);
            String letters = map.get(c);
            for (int i = 0; i < letters.length(); i++){
                combination.append(letters.charAt(i));
                backtrackss(map,combinations,combination,index+1,digits);
                combination.deleteCharAt(index);
            }
        }
    }

}

    //private void backTrack(List<String> combinations, HashMap<Character, String> map, String digits, int index,
    //    StringBuilder combination) {
    //    if (index == digits.length()){
    //        combinations.add(combination.toString());
    //    } else {
    //        char c = digits.charAt(index);
    //        String letters = map.get(c);
    //
    //        for (int i = 0; i < letters.length(); i++){
    //            combination.append(letters.charAt(i));
    //            backTrack(combinations,map,digits,index+1,combination);
    //            combination.deleteCharAt(index);
    //        }
    //
    //    }
    //}

