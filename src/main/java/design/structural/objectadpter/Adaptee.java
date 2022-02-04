package design.structural.objectadpter;

/**
 * @ClassName Adaptee
 * @Description
 * @Author liubo
 * @Date 2021/7/3 9:49 下午
 **/
public class Adaptee {
    public void request(Integer userId){
        System.out.println("只需传入userId:" + userId);
    }
}
