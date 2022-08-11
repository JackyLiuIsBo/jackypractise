package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class RandomShulff384 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        RandomShulff384 test = new RandomShulff384(nums);

        int[] shuffle = test.shuffle();
        for (int n : shuffle
        ) {
            System.out.println(n);
        }
    }
        int[] copy;
        int[] arrays;
        Random random;

    public RandomShulff384( int[] nums){
            copy = nums.clone();
            this.arrays = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset () {
            copy = arrays.clone();
            return arrays;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle () {
            for (int i = 0; i < arrays.length; i++) {
                int n = randRange(i + 1, copy.length);
                swap(copy, i, n);
            }
            return copy;
        }

        private int randRange ( int min, int max){

            return random.nextInt(max - min) + min;
        }

        public void swap ( int[] array, int left, int right){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

        //    private int[] array;
        //    private int[] original;
        //
        //    public static void main(String[] args) {
        //        int [] nums = {1,2,3};
        //        RandomShulff384 test = new RandomShulff384(nums);
        //
        //        int[] shuffle = test.shuffle();
        //        for (int n:shuffle
        //             ) {
        //            System.out.println(n);
        //        }
        //    }
        //    Random rand = new Random();
        //
        //    private int randRange(int min, int max) {
        //        return rand.nextInt(max - min) + min;
        //    }
        //
        //    private void swapAt(int i, int j) {
        //        int temp = array[i];
        //        array[i] = array[j];
        //        array[j] = temp;
        //    }
        //
        //    public  RandomShulff384(int[] nums) {
        //        array = nums;
        //        original = nums.clone();
        //    }
        //
        //    public int[] reset() {
        //        array = original;
        //        original = original.clone();
        //        return original;
        //    }
        //
        //    public int[] shuffle() {
        //        for (int i = 0; i < array.length; i++) {
        //            swapAt(i, randRange(i, array.length));
        //        }
        //        return array;
        //    }

    }
