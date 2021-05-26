package designs.pattern.structural.proxy.dynamicproxy;

/**
 * @ClassName Teacher
 * @Description
 * @Author liubo
 * @Date 2021/4/20 8:06 下午
 **/
public class Teacher implements Person{
    @Override
    public void makeLive() {
        System.out.println("teaching");
    }
}
