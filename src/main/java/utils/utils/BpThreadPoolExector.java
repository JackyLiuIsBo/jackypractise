package utils.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: gaoweiqiang
 * @email: gao.gwq@alibaba-inc.com
 * @Date: 2019/11/15 12:09 下午
 * @Version: 1.0
 * @Description: TODO
 */
public class BpThreadPoolExector extends ThreadPoolExecutor {

    private static final RejectedExecutionHandler defaultHandler =
            new AbortPolicy();
    private String poolName = "default";
    private static final ThreadLocal<Long> START_TIME = new ThreadLocal<Long>();
    private static final Logger logger = LoggerFactory.getLogger(BpThreadPoolExector.class);

    public BpThreadPoolExector(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                               TimeUnit unit, BlockingQueue<Runnable> workQueue, String poolName) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        if(poolName != null){
            this.poolName = poolName;
        }

    }

    public BpThreadPoolExector(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                               TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory());
    }

    public BpThreadPoolExector(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                               BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, defaultHandler);
    }

    public BpThreadPoolExector(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(), handler);
    }
    public BpThreadPoolExector(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
                               BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler, String poolName) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(), handler);
        if(poolName != null){
            this.poolName = poolName;
        }
    }
    public BpThreadPoolExector(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    @Override
    protected void beforeExecute(Thread t, Runnable runnable) {
        logger.info("线程池名称:{},任务{},开始执行,开始时间{}", poolName, t.getName(), System.currentTimeMillis());
        super.beforeExecute(t, runnable);
        long startTime = System.currentTimeMillis();
        START_TIME.set(startTime);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        long endTime = System.currentTimeMillis();
        long startTime = START_TIME.get();
        logger.info("线程池名称:{},任务{},执行结束，耗时{}", poolName, Thread.currentThread().getName(), (endTime - startTime));
        START_TIME.remove();
    }
}
