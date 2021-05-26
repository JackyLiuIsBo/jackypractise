package pracktiseskill.heapOrStackAndDequeue;

import java.util.PriorityQueue;

/**
 * @ClassName MedianFinder
 * @Description
 * @Author liubo
 * @Date 2021/5/7 8:50 下午
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 **/
public class MedianFinder {
    /** initialize your data structure here. */
    private int count = 0;

    private PriorityQueue<Integer> maxHeap = null;

    private PriorityQueue<Integer> minHeap  = null;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(((o1, o2) -> {
            return o2 - o1;
        }));
        minHeap = new PriorityQueue<>(((o1, o2) -> {
            return o1 -o2;
        }));

    }

    public void addNum(int num) {
        count++;
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if((count & 1) != 0){
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if((count & 1) != 0){
            return (double)maxHeap.peek();
        }
        return (double)(maxHeap.peek() + minHeap.peek()) / 2;

    }
}
