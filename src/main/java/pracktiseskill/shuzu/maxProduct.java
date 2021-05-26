package pracktiseskill.shuzu;

/**
 * @ClassName maxProduct
 * @Description
 * @Author liubo
 * @Date 2021/5/6 11:47 下午
 **/
public class maxProduct {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, -1};
        int i = maxProduct2(nums);
        System.out.println(i);
    }

    public static int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));

            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }

    public static int maxProduct2(int[] nums) {
        int tempMax = 1, tempMin = 1, max = Integer.MIN_VALUE;
        for(int num : nums){
            if (num < 0){
                int temp = tempMax;
                tempMax = tempMin;
                tempMin = temp;
            }

            tempMax = Math.max(num,tempMax * num);

            tempMin = Math.min(num,num * tempMin);

            max = Math.max(max,tempMax);
        }
        return max;
    }
}
