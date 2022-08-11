package leetcode.twopoint;/**
 * @program: jackypractise
 * @description: https://leetcode.com/problems/reverse-linked-list-ii/
 * @author: liubo
 * @date: 2022-05-31 01:18
 **/

import offer.ListNode;

/**
 @ClassName reverseBetween
 @Description
 @Author liubo
 @Date 2022/5/31 1:18 AM
 **/
public class reverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return revers(head,right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }
    ListNode tail = null;
    public ListNode revers(ListNode head,int right){
        if (right == 1){
            tail = head.next;
            return head;
        }
        //result节点变成了头节点
        ListNode result = revers(head.next,right-1);
        head.next.next = head;
        head.next = tail;
        return result;
    }
}
