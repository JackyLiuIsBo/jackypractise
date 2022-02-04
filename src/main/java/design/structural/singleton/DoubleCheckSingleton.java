package design.structural.singleton;

/**
 * @ClassName DoubleCheckSingleton
 * @Description
 * @Author liubo
 * @Date 2021/7/3 10:10 下午
 **/
public class DoubleCheckSingleton {

    private volatile DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton(){
    }

    public DoubleCheckSingleton getDoubleCheckSingleton(){
        if (doubleCheckSingleton == null){
            synchronized (DoubleCheckSingleton.class){
                if (doubleCheckSingleton == null){
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }
}
