package concurrent.problems;

/**
 * @ClassName FooPrint
 * @Description
 * @Author liubo
 * @Date 2021/5/22 8:00 下午
 * 1114. 按序打印
 * 我们提供了一个类：
 *
 * public class Foo {
 *   public void first() { print("first"); }
 *   public void second() { print("second"); }
 *   public void third() { print("third"); }
 * }
 * 三个不同的线程 A、B、C 将会共用一个 Foo 实例。
 *
 * 一个将会调用 first() 方法
 * 一个将会调用 second() 方法
 * 还有一个将会调用 third() 方法
 * 请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。
 **/
public class FooPrint {
    volatile int state = 0;
    public FooPrint() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        state = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        if (state == 1){
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
    }
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
