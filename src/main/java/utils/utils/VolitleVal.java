package utils.utils;

/**
 * @ProjectName: alscadkbbp
 * @Package: com.alibaba.o2o.ad.kbbp.utils
 * @Author: gao.gwq@alibaba-inc.com
 * @Date: 2020/9/16 9:31 下午
 * @Version: 1.0
 * @Description: TODO
 */
public class VolitleVal<T> {
    private T value;

    public VolitleVal(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
