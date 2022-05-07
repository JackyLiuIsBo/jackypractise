package leetcode.dfs;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.Stack;

/**
 * link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * experience:
 */
public class kthSmallest {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(4);
        head.left.right = new TreeNode(2);
        int n = kthSmallest1(head, 1);
        System.out.println(n);
        HashMap hashMap = new HashMap();
    }

    /**
     * 使用递归，中序遍历，需要设定两个变量来记录相关k值和结果值，java不能进行值传递
     */
    int count = 0;
    int result = 0;
    private void getResult(TreeNode root){
        if(root == null){
            return ;
        }
        getResult(root.left);
        count--;
        if(count == 0){
            result = root.val;
        }
        getResult(root.right);
    }

    /**
     * 使用迭代的方法进行中序遍历
     * @param root
     * @param k
     * @return
     */

    public static int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                k--;
                if (0 == k) {
                    return root.val;
                }
                //这里不需要对root.right进行判空
                root = root.right;
            }
        }
        return -1;
    }
}
