package pracktiseskill.hot100;

import offer.ListNode;

/**
 * @ClassName sortList
 * @Description
 * @Author liubo
 * @Date 2021/5/16 6:23 下午
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * url： https://leetcode-cn.com/problems/sort-list/
 **/
public class sortList {
    public static void main(String[] args) {
        int [][] arrays = {{0,0,0,0},{0,1,1,1}};
        int [][] dig = {{0,0},{0,1}};
        int[] nums = {3,2,1};
        nextPermutation(nums);
    }


    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);

    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }



    public ListNode sortLists(ListNode head){
        ListNode faster = head.next, slow = head;

        while (faster != null){
            if(faster.next == null){
                break;
            }
            faster = faster.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortLists(head);
        ListNode right = sortLists(temp);

        ListNode res = new ListNode(0);
        ListNode rs = res;

        while (left != null && right != null){
            if (left.val > right.val){
                res.next = left;
                left = left.next;
            }else {
                res.next = right;
                right = right.next;
            }
            res = res.next;
        }
        res.next = (left == null) ? right : left;

        return rs.next;
    }









    public ListNode sortList(ListNode head) {
        //递归结束条件
        if (head == null || head.next == null)
            return head;
        //起始点也不能一样
        ListNode fast = head.next, slow = head;
        //
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        //这里需要置null
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;


        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;

    }
}
