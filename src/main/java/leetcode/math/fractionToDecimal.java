package leetcode.math;

import java.util.HashMap;

/**
 *
 */
public class fractionToDecimal {
    public static void main(String[] args) {
        String s = fractionToDecimals(-1,
                -2147483648);
        System.out.println(s);
    }

    private static String fractionToDecimals(int numerator,int denominator){
        String flag = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        StringBuilder result = new StringBuilder();
        //（long）不能放在外面，不染abs（）里面的数为-2147483648时，依旧会超范围
        long num = Math.abs((long) numerator);
        long denum =  Math.abs((long) denominator);
        result.append(flag);
        result.append(num / denum);
        long reminder = num % denum;
        if (reminder == 0){
            return result.toString();
        }
        result.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        //求余数的核心方法
        while (!map.containsKey(reminder)){
            map.put(reminder,result.length());
            reminder = reminder * 10;
            result.append(reminder /denum);
            reminder = (reminder ) % denum;

        }
        //StringBuilder有insert方法，可以按照索引进行插入
        result.insert(map.get(reminder),"(");
        result.append(")");

        return result.toString().replace("(0)","");
    }








    public static String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        result.append(sign);
        result.append(num / den);
        long remainder = num % den;
        if (remainder == 0)
            return result.toString();
        result.append(".");
        HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
        //核心步骤
        while (!hashMap.containsKey(remainder)) {
            //如果余数和前面的余数相同，则后面的为循环
            hashMap.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        int index = hashMap.get(remainder);
        result.insert(index, "(");
        result.append(")");
        return result.toString().replace("(0)", "");
    }
}
