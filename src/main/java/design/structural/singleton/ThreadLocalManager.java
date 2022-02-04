package design.structural.singleton;

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import org.reflections.Reflections;

/**
 * @ClassName ThreadLocalManager
 * @Description
 * @Author liubo
 * @Date 2021/7/3 10:35 下午
 **/
public class ThreadLocalManager extends AbtractThreadLocal {

    private static List<AbtractThreadLocal> threadLocalList = Lists.newArrayList();

    private ThreadLocalManager(){}
    private static class InnerClass {
        private static ThreadLocalManager threadLocalManager = new ThreadLocalManager();
    }

    static {
        Reflections reflection = new Reflections(AbtractThreadLocal.class.getPackage().getName());

        Set<Class<? extends AbtractThreadLocal>> classSet = reflection.getSubTypesOf(AbtractThreadLocal.class);
        for (Class<? extends AbtractThreadLocal> test : classSet) {
            try {
                AbtractThreadLocal threadLocal = test.newInstance();
                threadLocalList.add(threadLocal);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    public static ThreadLocalManager getInstance() {
        return InnerClass.threadLocalManager;
    }

    //在filter或者拦截器里执行该方法
    @Override
    public void remove() {
        for (AbtractThreadLocal abtractThreadLocal : threadLocalList) {
            if (!(abtractThreadLocal instanceof ThreadLocalManager)) {
                abtractThreadLocal.remove();
            }
        }
    }
}

