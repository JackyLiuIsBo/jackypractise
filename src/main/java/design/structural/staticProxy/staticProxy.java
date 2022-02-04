package design.structural.staticProxy;

/**
 * @ClassName staticProxy
 * @Description
 * @Author liubo
 * @Date 2021/7/3 9:39 下午
 **/
public class staticProxy implements Account{
    private Account account;

    public staticProxy(Account account){
        this.account = account;
    }

    @Override
    public void transfer(){
        account.transfer();
    }
}
