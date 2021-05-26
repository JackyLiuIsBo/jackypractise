package pracktiseskill.SortAlogrithm;

import java.util.Random;

/**
 * @ClassName distribute
 * @Description
 * @Author liubo
 * @Date 2021/5/5 11:58 上午
 **/
public class distribute {

    private int[] array;
    private int[] original;

    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private void swapAt(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void Solution(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }
        return array;
    }

    public static void main(String[] args) {
        boolean powerOfThree = isPowerOfThree(45);
        System.out.println(powerOfThree);
    }

    public static boolean isPowerOfThree(int n) {
        if(n < 1){
            return false;
        }
        if(n == 1){
            return true;
        }

        if (n % 3 != 0){
            return false;
        }

        return isPowerOfThree(n/3);
    }
}
