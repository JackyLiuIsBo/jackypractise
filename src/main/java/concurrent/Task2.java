package concurrent;

/**
 * @ClassName Task2
 * @Description
 * @Author liubo
 * @Date 2021/6/6 11:19 下午
 **/
public class Task2 implements Runnable{
    private String  value ;

    public Task2(String  value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName() + "发送补偿消息::" +":  "+ value);
    }
}
