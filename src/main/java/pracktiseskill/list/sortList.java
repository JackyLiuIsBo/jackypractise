package pracktiseskill.list;

import offer.ListNode;
import pracktiseskill.list.copyRandomList.Node;

/**
 * @ClassName sortList
 * @Description
 * @Author liubo
 * @Date 2021/5/8 10:28 下午
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 * 相关标签
 *

 **/
public class sortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        //关键点，在四个节点的情况下，fast需要 = head.next;
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(temp);
        ListNode tem = new ListNode(0);
        ListNode result = tem;
        while (left != null && right != null){
            if (left.val < right.val){
                result.next = left;
                left = left.next;
            }else {
                result.next = right;
                right = right.next;
            }
            result = result.next;
        }
        result.next = left != null ? left : right;

        return tem.next;
    }


}
