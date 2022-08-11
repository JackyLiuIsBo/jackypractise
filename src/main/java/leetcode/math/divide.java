package leetcode.math;

/**
 * 整理了一下思路，可以简单概括为： 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
 *
 */
public class divide {
    public static void main(String[] args) {
        divide divide = new divide();
        int div = divide.divide(10, 3);
        System.out.println(div);
    }

    public int divide(int dividend, int divisor) {
        if(dividend ==  Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        //确定返回结果的正负
        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = -divisor;
        String str = "";
        char[] chars = str.toCharArray();
        return isNeg? -div(dividend, divisor) : div(dividend, divisor);
    }


    public int div(int divid, int divis){
        if(divid > divis) return 0;

        int curSum = divis << 1, prevSum = divis, q = 1;
        //可以简单概括为： 60/8 = (60-32)/8 + 4 = (60-32-16)/8 + 2 + 4 = 1 + 2 + 4 = 7
        while(divid <= curSum && curSum < prevSum){
            prevSum = curSum;
            curSum <<= 1; q <<= 1;
        }
        return q + div(divid - prevSum, divis);
    }
}
