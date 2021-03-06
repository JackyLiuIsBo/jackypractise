package offer;


import java.util.*;

/**
 * 给定一个数组和滑动窗口的大小，
 * 找出所有滑动窗口里数值的最大值。例如，
 * 如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */
public class MaxWindow {
    public static void main(String[] args) {
        int [] num = {10,14,12,11};
        ArrayList<Integer> list = maxInWindows(num, 4);
        for (Integer n :
                list) {
            System.out.println(n);
        }
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size){


        ArrayList<Integer> result = new ArrayList();

        if(size == 0 || num == null || num.length == 0 || num.length < size){
            return result;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1,o2)->o2-o1);
        //                                                         );
        //       PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1,o2)->o2-o1);//大顶堆

        for(int i = 0; i < size; i++){
            queue.offer(num[i]);
        }

        for(int i = size; i < num.length; i++){

            result.add(queue.peek());
            queue.remove(num[i-size]);
            queue.offer(num[i]);
        }
        result.add(queue.peek());
        return result;
        //PriorityQueue<Integer> queue = new PriorityQueue<>((t1,t2)-> t2 - t1);
        //
        ////PriorityQueue<Integer> queue = new PriorityQueue<>(
        ////    (t1,t2)-> t2 - t1);
        //
        //ArrayList<Integer> list = new ArrayList<>();
        //if (num.length < size){
        //    return list;
        //}
        //for (int i = 0; i < size; i++){
        //    queue.offer(num[i]);
        //}
        //int count = 0;
        //for (int i = size; i < num.length; i++){
        //    list.add(queue.peek());
        //    queue.remove(num[count++]);
        //    queue.offer(num[i]);
        //}
        //list.add(queue.peek());
        //return list;
    }
}
