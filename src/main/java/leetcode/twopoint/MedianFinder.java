package leetcode.twopoint;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * https://mp.weixin.qq.com/s/oklQN_xjYy--_fbFkd9wMg
 */
public class MedianFinder {
    public static void main(String[] args) {
        LocalDate local = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
      //  System.out.println(now);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yy-MM-dd:hh-mm-ss");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);
    }
    PriorityQueue<Integer> maxQueue;
    PriorityQueue<Integer> minQueue;
    public MedianFinder() {
        minQueue = new PriorityQueue<>();
        maxQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
    }

    public void addNum(int num) {
        if (maxQueue.size() < minQueue.size()){
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
        }else {
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
        }
    }

    public double findMedian() {
        int size = minQueue.size() + maxQueue.size();
        return (size % 2 == 0) ? ((minQueue.peek() + maxQueue.peek()) / 2.0) : (maxQueue.size() > minQueue.size() ?
                maxQueue.peek() : minQueue.peek());
    }
}
