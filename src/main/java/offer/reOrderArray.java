package offer;

import java.util.Arrays;

public class reOrderArray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5, 4, 6, 7, 8, 10};
        reOrderArray(nums);
        Arrays.stream(nums).asLongStream().forEach(t -> System.out.println(t+"  "));
    }

    public static void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = array.length - 1; j > i; j--){
                if ((array[j] & 1) == 0 && (array[j-1] & 1) == 1) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}
