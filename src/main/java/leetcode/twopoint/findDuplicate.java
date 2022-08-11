package leetcode.twopoint;

/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class findDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 1,fast = 1;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        slow = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
