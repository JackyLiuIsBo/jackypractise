package leetcode.math;

import offer.ListNode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class isPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        boolean palindrome = isPalindrome(s);
        int[] nums = {1};
        int[] ints = Arrays.copyOf(nums, nums.length);
        System.out.println(palindrome);
    }
    public static boolean isPalindrome(String s) {
        int left = 0,right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right){
            while (left < right &&!Character.isLetterOrDigit(chars[left])){
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(chars[right])){
                right--;
            }
            char leftChar = chars[left];
            if (Character.isUpperCase(chars[left])){
                leftChar = Character.toLowerCase(chars[left]);

            }
            char rightChar = chars[right];
            if (Character.isUpperCase(chars[right])){
                rightChar = Character.toLowerCase(chars[right]);
            }
            if (leftChar != rightChar){
                return false;
            }
            left++;
            right--;
        }
        return  true;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head,fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        slow = resver(slow);
        fast = head;
        while (slow != null){
            if (slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    private ListNode resver(ListNode fast) {
        ListNode pre = null;
        while (fast != null){
            ListNode next = fast.next;
            fast.next = pre;
            pre = fast;
            fast = next;
        }
        return pre;
    }
}
