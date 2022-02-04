package concurrent.lock;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @ClassName Sephmore
 * @Description
 * @Author liubo
 * @Date 2021/6/16 9:38 下午
 **/
public class Sephmore {

    private int n;
    private volatile int m = 1;
    private volatile int flag = 0;

    public Sephmore(int n) {
        this.n = n;
    }

    public static void main(String[] args) throws InterruptedException {
        Sephmore sephmore = new Sephmore(3);
        sephmore.fizz(new Runnable() {
            @Override
            public void run() {
                System.out.println("fizz");
            }
        });

        sephmore.buzz(()->{
            System.out.println("buzz");
        });

        sephmore.fizzbuzz(()->{
            System.out.println("fizzbuzz");
        });
        sephmore.number(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
    }
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(m <= n){
            while(flag !=1 && m <= n){
                Thread.yield();
            }
            if(m > n){
                return;
            }
            if(m % 3 == 0){
                printFizz.run();
                m++;
                flag = 0;
            }else{
                flag = 2;
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(m <= n){
            while(flag != 2 && m <= n){
                Thread.yield();
            }
            if(m > n){
                return;
            }
            if(m % 5 == 0){
                printBuzz.run();
                m++;
                flag = 0;
            }else{
                flag = 3;
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(m <= n){
            while(flag != 0 && m <= n){
                Thread.yield();
            }
            if(m > n){
                return;
            }
            if(m % 3 == 0 && m % 5 == 0){
                printFizzBuzz.run();
                m++;
                flag = 0;
            }else{
                flag = 1;
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(m <= n){
            while(flag != 3 && m <= n){
                Thread.yield();
            }
            if(m > n){
                return;
            }
            printNumber.accept(m);
            m++;
            flag = 0;
        }
    }

}
