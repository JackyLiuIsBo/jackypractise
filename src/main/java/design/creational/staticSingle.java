package design.creational;

/**
 * @ClassName staticSingle
 * @Description
 * @Author liubo
 * @Date 2021/5/24 12:27 上午
 **/
public class staticSingle {
    private staticSingle(){

    }
    public static   class inner{
        static staticSingle instance = new staticSingle();
    }

    public static staticSingle getInstance(){
        return inner.instance;
    }
}
