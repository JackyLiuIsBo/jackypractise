package leetcode.character;

import org.springframework.util.StringUtils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 *
 */
public class calculate227 {
    public static void main(String[] args) {
        int [][] arrays = {{1,4},{2,5},{4,7},{10,15}};

        String s = "3+2*2";
        int calculate = calculates(s);


        System.out.printf(String.valueOf(calculate));
    }

    public static int calculates(String s) {
        char operator = '+';
        s += "+0";
        int num = 0;
        Stack<Integer> stack = new Stack();
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else{
                switch(operator){
                    case '+' : stack.push(num); break;
                    case '-' : stack.push(-num);
                    case '*' : stack.push(stack.pop() * num);
                    case '/' : stack.push(stack.pop() / num);

                }
                operator = c;
                num = 0;
            }

        }
        int result = 0;
        for (Integer temp: stack
             ) {
            result += temp;
        }
        return stack.stream().mapToInt(Integer::valueOf).sum();
    }

    private static int calculate(String str){
        str +=  "+0";
        Character operator = '+';
        int num = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(Character c : str.toCharArray()){
            if(c == ' '){
                continue;
            }
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else {
                switch(operator){
                    case '+': stack.push(num); break;
                    case '-': stack.push(-num); break;

                    case '*': stack.push(stack.pop() * num); break;
                    case '/': stack.push(stack.pop() / num); break;
                }
                operator = c;
                num = 0;
            }
        }

        return stack.stream().mapToInt(Integer::valueOf).sum();

    }


















//    public static int calculate(String s) {
//        char preOperation = '+';
//        int num = 0;
//        Stack<Integer> stack = new Stack<>();
//        for (char c : s.toCharArray()) {
//            if (c == ' ') continue;
//            if (Character.isDigit(c)) {
//                num = num * 10 + (c-'0');
//            } else {
//                switch (preOperation) {
//                    case '+': stack.push(num); break;
//                    case '-': stack.push(-1 * num); break;
//                    case '*': stack.push(stack.pop() * num); break;
//                    case '/': stack.push(stack.pop() / num); break;
//                    default:
//                }
//                preOperation = c;
//                num = 0;
//            }
//        }
//        return stack.stream().mapToInt(Integer::intValue).sum();
//    }






}
