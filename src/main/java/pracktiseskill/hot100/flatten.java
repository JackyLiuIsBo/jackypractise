package pracktiseskill.hot100;

import leetcode.TreeNode;

/**
 * @ClassName flatten
 * @Description
 * @Author liubo
 * @Date 2021/5/15 11:36 下午
 * 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2,5,3,4,null,6]
 **/
public class flatten {
    //On复杂度的做法是寻找前置节点
    public void flatten(TreeNode root) {
        if(root == null){
            return ;
        }
        TreeNode cur = root;
        while(cur != null ){
            if(cur.left != null){
                TreeNode temp = cur;
                temp = temp.left;
                while(temp.right != null){
                    temp = temp.right;
                }
                temp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;

        }
    }
}
