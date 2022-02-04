package pracktiseskill.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName groupAnagrams
 * @Description
 * @Author liubo
 * @Date 2021/5/16 9:14 下午
 **/
public class groupAnagrams {
    public static void main(String[] args) {
        String [] strings = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strings);
        System.out.println(lists.toString());
        HashMap map = new HashMap();
        map.values();
        List<List<String>> result = new ArrayList();

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            chars.toString();
            String temp = Arrays.toString(chars);
            map.put(temp,map.getOrDefault(temp,new ArrayList<String>()));
            List<String> l = map.get(temp);
            l.add(str);
        }
        String temp = new String();
        char[] chars = temp.toCharArray();
        return new ArrayList<>(map.values());
    }
}
