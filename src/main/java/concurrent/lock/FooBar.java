package concurrent.lock;

import java.util.concurrent.Semaphore;

/**
 * @ClassName FooBar
 * @Description
 * @Author liubo
 * @Date 2021/6/16 10:44 下午
 **/
public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(5);
        fooBar.foo(() -> System.out.println("foo"));
        fooBar.bar(() -> System.out.println("bar"));
    }

    private Semaphore foo = new Semaphore(1);
    private Semaphore bar = new Semaphore(0);


    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();
            printFoo.run();
            bar.release();
        }
    }
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();
            printBar.run();
            foo.release();
        }
    }
}
