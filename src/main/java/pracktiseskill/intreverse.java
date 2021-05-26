package pracktiseskill;

/**
 * @ClassName intreverse
 * @Description
 * @Author liubo
 * @Date 2021/5/2 12:16 下午
 **/
public class intreverse {
    public static void main(String[] args) {
        int num = myAtoi("4193 with words");
        System.out.println(num);
    }
    public static int reverse(int x) {
        int rev = 0;
        while (x > 0){
            int temp = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && temp > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && temp < -8)) return 0;

            rev = rev * 10 + temp;
        }
        return rev;
    }
    static int count = 0;

    public static int myAtoi(String s) {
        if(s == null){
            return 0;
        }
        int flag = 1;
        flag = matrixPre(s);
        int result = 0;
        while(count < s.length()){
            int temp = s.charAt(count) - '1' + 1;
            if(temp < 10 && temp >=0){
                result = result * 10 + temp;

                if(result > Integer.MAX_VALUE ){
                    return Integer.MAX_VALUE;
                }

                if(result < Integer.MIN_VALUE ){
                    return Integer.MIN_VALUE;
                }
                count++;
            }else{
                break;
            }
        }

        return result * flag;
    }

    private static int matrixPre(String s){
        if(s == null){
            return 0;
        }
        while(s.charAt(count) == ' '){
            count++;
        }
        int flag = 1;
        if(s.charAt(count) == '-'){
            flag = -1;
            count++;
        }

        if(s.charAt(count) == '+'){
            flag = 1;
            count++;
        }
        return flag;
    }
}
