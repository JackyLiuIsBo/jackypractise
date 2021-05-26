package pracktiseskill.SortAlogrithm;

import java.util.Random;

import leetcode.TreeNode;

/**
 * @ClassName sortedArrayToBST
 * @Description
 * @Author liubo
 * @Date 2021/5/4 10:23 下午
 * 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 转换成二叉树一定要有返回值
 *
 **/
public class sortedArrayToBST {
    static TreeNode head = new TreeNode(-1);
    static Random random = new Random();
    public static void main(String[] args) {
        int [] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {


        head =    toBST(nums,0,nums.length - 1);
        return head;

    }

    public static TreeNode toBST(int [] nums,int start,int end){
        if(start <= end) {
            // 选择任意一个中间位置数字作为根节点

            int mid = (end - start) / 2 + start ;
            TreeNode head = new TreeNode(nums[mid]);

            head.left = toBST(nums, start, mid - 1);
            head.right =  toBST(nums,mid+1,end);
            return head;
        }
        return null;
    }
}
