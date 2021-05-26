package utils.utils;

import java.math.BigDecimal;

/**
 * @Description: 工具类，给工号补齐6位
 *
 * @Auther: liqingsong
 * @Date: 2019-03-07 10:51
 */
public class NumberUtil {

    public static String supply2Unite(String number){
        if (number.length() == 5){
            return "0"+number;
        }
        if (number.length() == 4){
            return "00"+number;
        }

        return number;
    }

    /**
     * 调整货币，根据参数设置要保留的位数和取舍
     * @param money 要格式化的数字
     * @param pos 要保留的小数位数
     * @param round 格式化时进行何种舍入，常见有以下方式：<code>ROUND_CEILING</code>，<code>ROUND_DOWN</code>，
     *              <code>ROUND_FLOOR</code>，<code>ROUND_HALF_DOWN</code>，<code>ROUND_HALF_EVEN</code>，
     *              <code>ROUND_HALF_UP</code>，<code>ROUND_UNNECESSARY</code>，<code>ROUND_UP</code>，
     *              详细请参看{@link BigDecimal}
     * @see BigDecimal
     * @return BigDecimal 返回BigDecimal对象类型，所有的格式由参数定义
     */
    public static BigDecimal fixMoney(BigDecimal money, int pos, int round) {
        BigDecimal result = null;

        if (money == null) {
            return null;
        }

        result = money.setScale(pos, round);

        return result;
    }

    public static void main(String[] args) {
//        Integer adGroupPrice = 1000;
//        Integer bidPrice = 100;
//
//        Double d1 = Double.valueOf(adGroupPrice)/100;
//        Double d2 = Double.valueOf(bidPrice)/100+1;
//
//        System.out.println(d1*d2);
//        System.out.println(d1*d2>=20);
        System.out.println(0.13*100);
//        Double d1 = 70D;
//        Double d2 = 100D;
//        System.out.println(d1/d2);
        BigDecimal bd = new BigDecimal(0.13*100);
        System.out.println(fixMoney(bd,1,BigDecimal.ROUND_HALF_UP));
    }
}
