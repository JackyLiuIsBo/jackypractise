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
 **/
public class sortList {



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
