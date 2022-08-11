package leetcode.twopoint;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/reverse-nodes-in-k-group/
 * @author: liubo
 * @date: 2022-05-30 00:11
 **/

import offer.ListNode;

/**
 @ClassName reverseKGroup
 @Description
 @Author liubo
 @Date 2022/5/30 12:11 上午
 **/
public class reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;
        ListNode next = null;
        for(int i = 0; i < k; i++){
            next = head.next;
            if (next == null){
                return null;
            }
            head.next = pre;
            pre = head;
            head = next;
        }

        temp.next = reverseKGroup(head,k);
        return pre;
    }
}
