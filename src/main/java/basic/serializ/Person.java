package basic.serializ;

import java.io.Serializable;
import java.util.Stack;

public class Person implements Serializable {
    private String name;
    private String sex;

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public static void main(String[] args) {
        String s = "[";
        Stack<Character> stack = new Stack();
        for(Character c : s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != c){
                System.out.println("false");
            }

        }
        System.out.println("true");
    }
}
