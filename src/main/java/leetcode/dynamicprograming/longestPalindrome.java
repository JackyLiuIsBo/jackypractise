package leetcode.dynamicprograming;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class longestPalindrome {
    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
   private static String longestPalindrome(String str){
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++){
            int l1 = getLength(str, i, i);
            int l2 = getLength(str, i, i + 1);
            int len = Math.max(l1,l2);
            if (len > end - start){
                end = i + len / 2;
                start = i - (len - 1) / 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        int[] num = new int[2];

       Random random = new Random();
       int i = random.nextInt();
       return str.substring(start,end+1);

   }

   private static int getLength(String str,int left,int right){
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
   }
}
