package offer;

import java.util.ArrayList;

/**
 * @ClassName prinFromTairToHead
 * @Description
 * @Author liubo
 * @Date 2020/11/18 10:39 下午
 **/
public class prinFromTairToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> results = new ArrayList<>();
        if (listNode == null){
            return results;
        }
        ListNode head = null, pre = listNode;
        while (listNode != null){


             pre = listNode.next;

            listNode.next = head;

            head = listNode;

            listNode = pre;
        }
        while (head != null){
            results.add(head.val);
            head = head.next;
        }
        return results;
    }
}
