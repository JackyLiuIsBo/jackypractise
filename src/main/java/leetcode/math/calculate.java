package leetcode.math;

import java.util.ArrayDeque;
import java.util.Deque;

public class calculate {
    public static void main(String[] args) {
        int calculate = calculate("3+2*2");
        int n = 1;
        n = -~n;

        System.out.println(calculate);
    }
    public static int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        s += "+0";
        char[] chars = s.toCharArray();
        stack.push(0);
        char operator = '+';
        int num = 0;
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == ' '){
                continue;
            }
            if (Character.isDigit(chars[i])){
                num = chars[i] - '0';
                while (i + 1 < chars.length && Character.isDigit(chars[i+1])){
                    num = num * 10 + chars[i+1] - '0';
                    i++;
                }
                stack.push(num);
                num = 0;
            }else {
                Integer right = stack.pop();
                Integer left = stack.pop();
                switch (operator){
                    case '+' : stack.push(left);stack.push(right); break;
                    case '-' : stack.push(left);stack.push(-right); break;
                    case '/' : stack.push(left / right); break;
                    case '*' : stack.push(left * right); break;
                }
                operator = chars[i];

            }

        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
