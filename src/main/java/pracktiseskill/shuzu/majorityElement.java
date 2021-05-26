package pracktiseskill.shuzu;

/**
 * @ClassName majorityElement
 * @Description
 * @Author liubo
 * @Date 2021/5/7 5:40 下午
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 *采用多数人的摩尔投票法，
 **/
public class majorityElement {
    public int majorityElement(int[] nums) {
        int majorityCount = 1,temp = nums[0];

        for (int i = 1; i < nums.length; i++){
            if(temp == nums[i]){
                majorityCount++;
            }else {
                majorityCount--;
                if(majorityCount == 0){
                    temp = nums[i];
                    majorityCount = 1;
                }
            }

        }
        majorityCount = 0;
        for (int num : nums){
            if (num == temp){
                majorityCount++;
            }
        }


        return temp;
    }
}
