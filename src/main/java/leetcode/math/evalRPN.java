package leetcode.math;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class evalRPN {
    public static void main(String[] args) {
        evalRPN evalRPN = new evalRPN();
        int i = evalRPN.evalRPN(new String[]{"4","13","5","/","+"});
        System.out.println(i);

    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String token : tokens){
            if(token != "*" && token != "/" && token != "-" && token != "+"){
                stack.push(Integer.parseInt(token));
            }else{
                Integer left = stack.pop();
                Integer right = stack.pop();
                switch(token){
                    case "*": stack.push(right * left);break;
                    case "/": stack.push(right / left);break;
                    case "-": stack.push(right - left);break;
                    case "+": stack.push(right + left);break;
                }
            }
        }
        return stack.pop();
    }


}
