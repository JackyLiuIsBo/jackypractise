package leetcode;

/**
 * @ClassName firstMissingPositive41
 * @Description
 * @Author eleme
 * @Date 2020/12/14 3:35 下午
 **/
public class firstMissingPositive41 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if (nums[i] <= 0){
                nums[i] = length + 1;
            }
        }

        for (int i = 0; i < length; i ++){
            int num = Math.abs(nums[i]);
            if (num <= length){
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for(int i = 0; i < length; i++){
            if (nums[i] > 0){
                return i + 1;
            }
        }
        return length + 1;
    }
}
