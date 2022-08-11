package leetcode.math;

public class myPow {
    public static void main(String[] args) {
        double v = myPow(1, 32323212);
        System.out.println(v);
    }

    public static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        /**
         * 避免出现2.00000
         * -2147483648,导致整型溢出
         */
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        /**
         * 避免1.00000
         * 2147483647导致超时
         */
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }

    public static double myPows(double x, int n) {
        double result = 1;
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        //这种方法在n特别大的时候会超时
        while(n != 0){
            result *=  x;
            n--;
        }

        return result;
    }
}
