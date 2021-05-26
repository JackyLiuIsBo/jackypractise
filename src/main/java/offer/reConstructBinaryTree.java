package offer;

import java.util.Arrays;

public class reConstructBinaryTree {
    public static void main(String[] args) {
        int [] pre = {1,2,3,4,5,6,7}, in = {3,2,4,1,6,5,7};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println(treeNode.val);

        System.out.println(Arrays.copyOfRange(pre,0,1).length);
    }

    private static TreeNode reConstructBinaryTree(int[] pre,int[] in){
        if (pre.length == 0 || in.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int i = 0;
        for ( ; i < in.length; i++){
            if (in[i] == pre[0]){
                break;
            }
        }

        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));

        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
        return root;
    }

















    //public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
    //    if (pre.length == 0 || in.length == 0){
    //        return null;
    //    }
    //    TreeNode root = new TreeNode(pre[0]);
    //    int count = 0;
    //    for(int i = 0; i < in.length; i++){
    //        if(in[i] == pre[0]){
    //            count = i;
    //            break;
    //        }
    //    }
    //    root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,8
    //    ]count+1),Arrays.copyOfRange(in,0,count));
    //    root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,count+1,pre.length),Arrays.copyOfRange(in,count+1,in.length));
    //    return root;
    //}
}
