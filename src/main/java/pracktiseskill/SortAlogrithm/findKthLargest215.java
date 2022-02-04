package pracktiseskill.SortAlogrithm;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

import javax.persistence.criteria.CriteriaBuilder.In;

public class findKthLargest215 {
//复杂度分析

    /**
     * 析算法可知，每一轮递归开始之前，我们已经消去了1个集合，递归仅作用在另外一个集合，结论2于是成立。结论3的推导依赖结论1。
     *
     *      在理想情况下，枢纽元 v 的选择使每轮递归都近似的将当前集合等分，故最多需要递归O（logN）次：
     *
     *          第1次递归对应的集合长度为 |S / 2|，
     *
     *          第2次递归对应的集合长度为 |S / 4|，
     *
     *          第3次递归对应的集合长度为 |S / 8|，
     *
     *          ......
     *
     *          第log(N) 次递归对应的集合长度为 1，
     *
     *      将O（logN）次递归的集合长度相加，
     *
     *          Sum = |S / 2| + |S / 4| + |S / 8| + ...... + 1
     *
     *      这是等比数列，根据等比数列求和方法可得Sum大约等于2N，故快速选择的平均时间复杂度为O（N）。
     * ————————————————
     * 版权声明：本文为CSDN博主「Paul-LangJun」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/gaoxueyi551/article/details/89354354
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {4, 2, 7, 5, 6, 9, 1,0,-1};
        //LinkedList<Integer> linkedList  = new LinkedList<>();
        //linkedList.add(2);
        //linkedList.add(4);
        //Deque<Integer> list  = new LinkedList<>();
        //list.add(2);
        //
        //list.offer(2);
        //Stack<Integer> stack = new Stack<>();
        //stack.add(2);
        //stack.push(2);
        //stack.pop();
        //System.out.println(Arrays.toString(linkedList.toArray()));


        topK(array,4);
    }
    //public static int findKthLargest1(int[] a, int k) {
    //    //n的取值需要减 1
    //    int n = a.length - 1;
    //    int p = topK(a, n,k);
    //    System.out.println("number is :" + a[p]);
    //    return a[p];
    //}

    private static int topK(int [] array,int k){
        int select = select(array, 0, array.length-1, k);
        System.out.println("position:" + (select));
        System.out.println("number is :" + array[select]);

        return array[select];
    }

    private static int select(int [] array,int left, int right,int k){
        int pos = partion(array,left,right);

        if (pos + 1 > k){
            return select(array,left,pos,k);
        }else if (pos + 1  < k){
            return select(array,pos + 1,right,k);
        }else {
            return pos;
        }

    }

    private static int partion(int [] array,int left,int right){
        int temp = array[left],start = left,end = right;

        while (start < end){

            while (start < end && array[end] <= temp){
                end --;
            }

            array[start] = array[end];

            while (start < end && array[start] > temp){
                start ++;
            }

            array[end] = array[start];
        }

        array[start] = temp;
        return start;

    }

















    //private static int select(int[] array,int left, int right, int k){
    //    int pos = partion(array,left,right);
    //    // 此处的处理需要加1，因为 数组是从0开始算，而名次是从1开始
    //    if (pos - left + 1 > k){
    //       return select(array,left,pos,k);
    //
    //    }else if (pos - left + 1 < k){
    //        //此处非常关键的判断 ：：需要将pos的位置 +1，因为已经能排除该pos点并不能满足要求，另外因为前面pos个数都小于目标值，故需改变k的值
    //       return select(array,pos + 1,right,k - (pos - left + 1));
    //    }else {
    //        return pos;
    //    }
    //
    //}
    //
    //private  static int partion(int[] array, int left, int right) {
    //    int start = left, end = right, temp = array[left];
    //    // 因为需要变动判断数组的值，因此需要用start,end变量来替代left和right;
    //    while (start < end){
    //        //这种partion的写法是取了left的值，因此需要和end的数组值进行替换，因此需要先判断右侧 的end
    //        while (start < end && array[end] > temp){
    //            end--;
    //        }
    //        array[start] = array[end];
    //        while (start < end && array[start] <= temp){
    //            start++;
    //        }
    //        array[end] = array[start];
    //    }
    //    array[start] = temp;
    //    return start;
    //
    //}


}
