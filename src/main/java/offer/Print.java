package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print {



    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
       if (pRoot == null){
           return result;
       }

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(pRoot);
        boolean flag = true;

        while (!queue.isEmpty()){
           LinkedList<Integer> list = new LinkedList<>();

           int size = queue.size();

           flag = !flag;

           while (size > 0){

               TreeNode poll = queue.poll();
               size--;
               if(flag){
                   list.add(poll.val);
               }else {
                   list.addFirst(poll.val);
               }


               if (poll.left != null){
                   queue.offer(poll.left);
               }

               if (poll.right != null){
                   queue.offer(poll.right);
               }


           }

           result.add(new ArrayList<>(list));

       }
        return result;
    }












    //ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    //        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    //        if (pRoot == null){
    //            return lists;
    //        }
    //    LinkedList<TreeNode> queue = new LinkedList<>();
    //     queue.offer(pRoot);
    //     ArrayList<Integer> list = new ArrayList<>();
    //     while (!queue.isEmpty()){
    //
    //        int size = queue.size();
    //         for (int i= 0; i < size; i++){
    //             TreeNode temp = queue.poll();
    //             list.add(temp.val);
    //             if (temp.left != null){
    //                 queue.offer(temp.left);
    //             }
    //             if (temp.right != null){
    //                 queue.offer(temp.right);
    //             }
    //         }
    //         lists.add(new ArrayList<>(list));
    //         list.clear();
    //     }
    //     return lists;
    //}
}
