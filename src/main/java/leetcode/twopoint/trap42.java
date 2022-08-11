package leetcode.twopoint;

import offer.ListNode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class trap42 {
    public static void main(String[] args) {
        int[] nums = {3,6,7,11};
    }

    public int minEatingSpeed(int[] piles, int h) {
        int sum = 0,minSpeed = 0,max = 0;
        for (int t : piles){
            sum += t;
            max = Math.max(t,max);
        }
        int maxSpeed = max * piles.length;
        minSpeed = sum / h + (sum % h == 0 ? 0 : 1);
        while (minSpeed < maxSpeed){
            int mid = (minSpeed + maxSpeed) / 2;
            if (isFix(mid,piles) <= h){
                maxSpeed = mid;
            }else {
                minSpeed = mid + 1;
            }
        }
        return minSpeed;
    }

    private int isFix(int mid,int[] piles){
        int hours = 0;
        for (int i = 0; i < piles.length; i++){
            hours += piles[i] / mid ;
            if (piles[i] % mid != 0){
                hours += 1;
            }
        }
        return hours;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1){
            return reverse(head,right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);

        return  head;
    }
    static ListNode tail = null;
    public static ListNode reverse(ListNode head,int right){
        if (right == 1){
             tail = head.next;

            return head;
        }
        ListNode reverse = reverse(head.next, right - 1);
        head.next.next = head;
        head.next = tail;
        return reverse;
    }

    public static int trap(int[] height) {
        int left = 0,right = height.length - 1;
        int lMax = 0,rMax = 0,result = 0;
        while (left < right){
            lMax = Math.max(lMax,height[left]);
            rMax = Math.max(rMax,height[right]);

            if (lMax < rMax){
                result += lMax - height[left];
                left++;
            }else {
                result += rMax - height[right];
                right--;
            }
        }
        return result;
    }
}
