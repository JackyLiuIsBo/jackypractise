package basic;

public class test {
    public static void main(String[] args) {
        float result = getResult(0.3F);
        System.out.println(result);
    }

    public static float getResult(float num) {

        float high = num, low = 0;
        if (num < 1){
            high = 1;
        }
        while (high >= low) {
            float mid = (high + low) / 2;
            float pow = mid * mid;
            if (pow == num) {
                return mid;
            }
            if (pow > num) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return (low + high) / 2;
    }
}
