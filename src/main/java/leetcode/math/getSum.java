package leetcode.math;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;

public class getSum {
    public static void main(String[] args) {
//        int sum = getSum(3, 7);
//        System.out.println(sum);
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(3);
        Iterator<Integer> iterator = set.iterator();

        Random random = new Random();
        int i = random.nextInt(2);
        System.out.println(i);

    }
    // temp = 11 & 1  << 1 = 10,digit = 11 ^ 1 = 10;
    public static int getSum(int a, int b) {
        int temp = 1;
        int digit = 0;
        while (temp != 0) {
            temp = a & b;
            temp <<= 1;
            digit = a ^ b;
            a = digit;
            b = temp;
        }

        System.out.println("temp" + temp + "  digit: " + digit);
        return a;
    }
}
