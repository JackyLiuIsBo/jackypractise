package basic.function;

import java.util.function.Function;

/**
 * @ClassName test
 * @Description
 * @Author liubo
 * @Date 2021/6/5 9:11 下午
 **/
public class test {
    public static class Something{
        public static void startWith(){
            System.out.println("'");
        }

        public <String> String startsWith(String s) {
            System.out.println("startwith");
            return s;
        }
    }
    public static void main(String[] args) {
        //Function<String, Integer> toInteger = Integer::valueOf;                                         //转Integer
        //Function<String, String> backToString = toInteger.andThen(String::valueOf);                     //转String
        //Function<String, String> afterToStartsWith = backToString.andThen(new Something()::startsWith); //截取第一位
        //String apply = afterToStartsWith.apply("123");// "123"
        //System.out.println(apply);
        callBack<Integer,String> callBack = new callBack<Integer, String>() {
            @Override
            public String call(Integer key) {
                return String.valueOf("value" + key);
            }
        };
        callBack<Integer,String> callBack1 = String::valueOf;
        System.out.println(callBack1.call(4));
    }


}
