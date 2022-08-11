package leetcode.math;

public class reverse {
    public static void main(String[] args) {
        int reverse = reverse(-2147483648);
        int i = -2147483648 * -1;
        System.out.println("fu: " + i);
        System.out.println(reverse);
    }
    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x *= sign;
        int ans = 0;
        while(x > 0) {
            if(Integer.MAX_VALUE / 10 < ans) return 0;
            ans = ans*10 + x%10;
            x /= 10;
        }
        return ans * sign;
    }
}
