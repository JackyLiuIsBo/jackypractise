package utils.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 分批处理工具,可对List和数组进行分批(不支持基本类型,非线程安全)
 *
 * @author lijiawei
 * @date 2019-02-16
 */
public class BatchProcessor<T> {

    private BatchProcessor(List<T> allList, int batchSize){
        this.allList = allList;
        this.batchSize = batchSize;
        this.allSize = allList.size();
    }

    /**
     * 创建分批处理器
     *
     * @param <T>
     * @param list
     * @param batchSize
     * @return
     * @author weijie.zhuangwj
     * @date 2011-3-16
     */
    public static <T> BatchProcessor<T> createProcessor(List<T> list, int batchSize) {

        if (batchSize <= 0) {
            throw new IllegalArgumentException("batchSize must bigger than zero");
        }
        if (list == null) {
            list = new ArrayList<T>();
        }
        return new BatchProcessor<T>(list, batchSize);
    }

    /**
     * 创建分批处理器
     *
     * @param <T>
     * @param array
     * @param batchSize
     * @return
     * @author weijie.zhuangwj
     * @date 2011-3-16
     */
    public static <T> BatchProcessor<T> createProcessor(T[] array, int batchSize) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        List<T> allList = new ArrayList<T>(Arrays.asList(array));
        return createProcessor(allList, batchSize);
    }

    /**
     * 是否有下一批
     *
     * @return
     * @author weijie.zhuangwj
     * @date 2011-3-16
     */
    public boolean hasNext() {
        if (toIndex >= allSize) {
            return false;
        }
        return true;
    }

    /**
     * 下一批长度，游标不向后前进
     *
     * @return
     * @author weijie.zhuangwj
     * @date 2011-3-22
     */
    public int nextLength() {
        if (toIndex >= allSize) {
            return 0;
        }
        if (toIndex + batchSize >= allSize) {
            return allSize - toIndex;
        }
        return batchSize;
    }

    /**
     * 取下一批，游标向后前进
     *
     * @return
     * @author weijie.zhuangwj
     * @date 2011-3-16
     */
    public List<T> next() {
        fromIndex = i * batchSize;
        toIndex = (i + 1) * batchSize;
        toIndex = (toIndex >= allSize) ? allSize : toIndex;
        i++;
        return allList.subList(fromIndex, toIndex);
    }

    /**
     * 取下一批，游标向后前进
     *
     * @return
     * @author weijie.zhuangwj
     * @date 2011-3-16
     */
    public T[] next(T[] array) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        if (array.length != nextLength()) {
            throw new IndexOutOfBoundsException("array length must equal array length:" + nextLength());
        }
        List<T> ret = next();
        return (T[]) ret.toArray(array);
    }

    private List<T>   allList;      // 所有的列表
    private final int batchSize;    // 批次长度
    private final int allSize;      // 所有长度

    private int       fromIndex = 0; // 分组截取列表的起始下标
    private int       toIndex   = 0; // 分组截取列表的终止下标
    private int       i         = 0; // 分组截取列表计数器

}
