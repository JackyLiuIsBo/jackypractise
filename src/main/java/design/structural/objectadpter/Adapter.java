package design.structural.objectadpter;

/**
 * @ClassName Adapter
 * @Description
 * @Author liubo
 * @Date 2021/7/3 9:47 下午
 **/
public class Adapter implements Target{
    private Adaptee adaptee ;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void request(int userId, int authId) {
        if(authId == 1) {
            adaptee.request(userId);
        }else {
            System.out.println("authId检验不通过");
        }
    }

}
