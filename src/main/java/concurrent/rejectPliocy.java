package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName rejectPliocy
 * @Description
 * @Author liubo
 * @Date 2021/6/5 10:36 上午
 **/
public class rejectPliocy implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        Task2 task = (Task2) r;
        String value = task.getValue();
        System.out.println("拒绝策略"+Thread.currentThread().getName() + "::" + value);
    }

    public static void main(String[] args) {
        //线程池7大参数
        ExecutorService threadPool = new ThreadPoolExecutor(
            1, 2, 20, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),
            new rejectPliocy());

        try {
            for (int i = 1; i <= 100; i++) {
                threadPool.execute(new Task2("excute Task2:::" + i));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
