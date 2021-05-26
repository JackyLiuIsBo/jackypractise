package offer;

/**
 * @ClassName Merge
 * @Description
 * @Author liubo
 * @Date 2020/11/19 12:07 上午
 **/
public class Merge {

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode result = new ListNode(0);
        if (list1 == null && list2 == null) {
            return result.next;
        }
        //}else if (list1 != null && list2 == null){
        //     result.next = list1;
        //     return result;
        //}else if (list1 == null && list2 != null){
        //    result.next = list2;
        //}

        ListNode head = result;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                result.next = list2;
                list2 = list2.next;

            }else {
                result.next = list1;
                list1 = list1.next;
            }

            result = result.next;
        }
        if (list1 != null){
            result.next = list1;
        }
        if (list2 != null){
            result.next = list2;
        }
        return head.next;

    }
}
