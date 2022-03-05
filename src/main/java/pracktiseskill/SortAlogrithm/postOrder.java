package pracktiseskill.SortAlogrithm;

import com.google.common.collect.Lists;
import offer.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;


public class postOrder {
    public static void main(String[] args) {
        LinkedList<Integer> list = Lists.newLinkedList();
        list.add(0);
        list.push(9);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(23);

        Stack<Integer> stack = new Stack<>();
        stack.push(32);
        stack.pop();
        arrayList.remove(arrayList.size()-1);
    }

    public void postOrder(TreeNode root){

        if (root == null){
            return;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null){
                stack1.push(root.left);
            }
            if (root.right != null){
                stack1.push(root.right);
            }
        }



    }















    //public void postOrder(TreeNode root){
    //   Stack<TreeNode> stack1 = new Stack<>();
    //   Stack<TreeNode> stack2 = new Stack<>();
    //   stack1.push(root);
    //   while (!stack1.isEmpty()){
    //       TreeNode pop = stack1.pop();
    //       stack2.push(pop);
    //       if (pop.left != null){
    //           stack1.push(pop.left);
    //       }
    //       if (pop.right != null){
    //           stack1.push(pop.right);
    //       }
    //   }
    //    while (!stack2.isEmpty()){
    //        TreeNode pop = stack2.pop();
    //    }
    //}
}
