package pracktiseskill.list;

import java.util.HashMap;

/**
 * @ClassName copyRandomList
 * @Description
 * @Author liubo
 * @Date 2021/5/8 7:35 下午
 **/
public class copyRandomList {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    HashMap<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        if (map.containsKey(head)){
            return map.get(head);
        }
        Node newHead = new Node(head.val);
        map.put(head,newHead);
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);
        return  newHead;
    }
    public Node copyRandomList2(Node head) {
        if (head == null){
            return null;
        }
        HashMap<Node,Node> map = new HashMap<>();
        //当前连标的头节点
        Node cur = head;
        Node temp = new Node(cur.val);
        //新连标的头节点
        Node result = temp;
        while (head != null){
            map.put(head,new Node(head.val));
            head = head.next;
        }

        while (cur != null){
            temp.next = map.get(cur);
            temp.random = map.get(cur.random);
            temp = temp.next;
            cur = cur.next;
        }
        return result;
    }
}
