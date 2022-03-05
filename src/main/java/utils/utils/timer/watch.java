package utils.utils.timer;/**
 * @program: jackypractise
 * @description: spring的watch时间统计工具类
 * @author: liubo
 * @date: 2022-02-04 17:05
 **/

import org.springframework.util.StopWatch;

/**
 @ClassName watch
 @Description
 @Author liubo
 @Date 2022/2/4 下午5:05
 **/
public class watch {
    private void test() throws InterruptedException {
        StopWatch sw = new StopWatch();

        sw.start("起床");
        Thread.sleep(1000);
        sw.stop();

        sw.start("洗漱");
        Thread.sleep(2000);
        sw.stop();

        sw.start("锁门");
        Thread.sleep(500);
        sw.stop();

        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
        System.out.println(sw.getLastTaskName());
        System.out.println(sw.getLastTaskInfo());
        System.out.println(sw.getTaskCount());
    }


    public static void main(String []argv) throws InterruptedException {
        watch testStopWatch = new watch();
        testStopWatch.test();
    }
}
