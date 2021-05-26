package design.creational;

import java.util.zip.DeflaterOutputStream;

public class DoubleCheckSingleton {
    private static   volatile DoubleCheckSingleton instance = null ;
    int state = 0;
    private DoubleCheckSingleton(){
    }

    public static DoubleCheckSingleton getInstance(){
        if (instance == null){
            synchronized(DoubleCheckSingleton.class){
                if (instance == null){
                    instance =  new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleCheckSingleton instance = DoubleCheckSingleton.getInstance();
    }
}
