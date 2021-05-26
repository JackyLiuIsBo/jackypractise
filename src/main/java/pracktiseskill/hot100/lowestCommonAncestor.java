package pracktiseskill.hot100;

import leetcode.TreeNode;

/**
 * @ClassName lowestCommonAncestor
 * @Description
 * @Author liubo
 * @Date 2021/5/16 4:24 下午
 **/
//todo
public class lowestCommonAncestor {
    //进行递归判断p,q节点是否是当前节点的自节点，如果有一个是，则返回一个。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归到叶子节点或者目标节点中的任何一个就结束递归
        if(q == root || p == root || root == null){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        //当前节点就是目标节点
        if (left != null && right != null){
            return root;
        }

        return left == null ? right : left;
    }
}
