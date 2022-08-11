package leetcode.twopoint;

import offer.ListNode;

public class removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head,fast = head;
        int temp = n;
        while (n-- != 0 && fast != null){
            fast = fast.next;
        }
        // 这里需要判断 n == 1和n == length的情况
        if (fast == null){
            slow = slow.next;
            return slow;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        if (temp == 1){
            slow.next = null;
        }
        return head;
    }
}
