package pracktiseskill.SortAlogrithm;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @ClassName isValid20
 * @Description
 * @Author liubo
 * @Date 2021/5/5 2:34 下午
 **/
public class isValid20 {

    public static void main(String[] args) {
        String str = "{[]}";
        boolean valid = isValid(str);
        System.out.println(valid);
    }

    private static HashMap<Character, Character> map = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    public static boolean isValid(String s) {
        boolean flag = true;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {


            if (map.containsKey(s.charAt(i)) && !stack.isEmpty()  ) {
                if (map.get(s.charAt(i)).equals(stack.peek())) {
                    stack.pop();
                    continue;
                } else {
                    flag = false;
                    break;
                }
            }
                stack.push(s.charAt(i));
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return flag;
    }
}
