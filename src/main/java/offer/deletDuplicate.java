package offer;

public class deletDuplicate {
    public ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode head = new ListNode(-1);
        head.next = pHead;

        ListNode temp = head, pre = head.next;

        while (pre != null) {
            if (pre.next != null && pre.val == pre.next.val) {
                while (pre.next != null && pre.val == pre.next.val) {
                    pre.next = pre.next.next;
                }
                pre = pre.next;
                temp.next = pre;
            } else {
                temp = pre;
                pre = pre.next;
            }
        }
        return head.next;
    }












        //ListNode head = new ListNode(-1);
        //head.next = pHead;
        //ListNode temp = head;
        //ListNode pre = head.next;
        //while (pre.next != null){
        //    if (pre.val == pre.next.val){
        //        while (pre.val == pre.next.val){
        //            pre = pre.next;
        //        }
        //        temp.next = pre.next;
        //        pre = pre.next;
        //    }else {
        //        pre = pre.next;
        //        temp = temp.next;
        //    }
        //}
        //return head.next;

}
