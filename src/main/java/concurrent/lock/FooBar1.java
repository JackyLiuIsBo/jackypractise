package concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName FooBar1
 * @Description
 * @Author liubo
 * @Date 2021/6/16 11:16 下午
 **/
public class FooBar1 {
    private int n;

    public FooBar1(int n) {
        this.n = n;
    }

    static Lock lock = new ReentrantLock(true);
     static volatile boolean permitFoo = true;

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(5);
        new Thread(()->{
            for (int i = 0; i < 5; i++){
                synchronized (lock){

                    if (permitFoo){
                        System.out.println("foo");
                        try {
                            permitFoo = false;
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notify();

                }
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 5; i++){
                synchronized (lock){
                    if (!permitFoo){
                        System.out.println("bar");
                        permitFoo = true;
                        lock.notify();
                    }
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();

        //new Thread(()->{
        //    for (int i = 0; i < 10; ) {
        //        lock.lock();
        //        try {
        //            if(permitFoo) {
        //                System.out.println("foo");
        //                i++;
        //                permitFoo = false;
        //            }
        //        }finally {
        //            lock.unlock();
        //        }
        //    }
        //}).start();
        //
        //new Thread(()->{
        //    for (int i = 0; i < 5; ) {
        //        lock.lock();
        //        try {
        //            if(!permitFoo) {
        //                System.out.println("bar");
        //                i++;
        //                permitFoo = true;
        //            }
        //        }finally {
        //            lock.unlock();
        //        }
        //    }
        //}).start();
        //
        //new Thread(()->{
        //    try {
        //        fooBar.bar(()->{
        //            System.out.println("bar");
        //        });
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //}).start();

    }
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if(permitFoo) {
                    printFoo.run();
                    i++;
                    permitFoo = false;
                }
            }finally {
                lock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if(!permitFoo) {
                    printBar.run();
                    i++;
                    permitFoo = true;
                }
            }finally {
                lock.unlock();
            }
        }
    }

}
