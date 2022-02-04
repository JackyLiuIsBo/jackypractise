package design.structural.staticProxy;

/**
 * @ClassName AccountImpl
 * @Description
 * @Author liubo
 * @Date 2021/7/3 9:40 下午
 **/
public class AccountImpl implements Account{
    @Override
    public void transfer() {
        System.out.println("transfer");
    }
}
