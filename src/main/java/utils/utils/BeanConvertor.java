package utils.utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.util.CollectionUtils;

/**
 * @description
 * @auther liqingsong
 * @date 2019-03-18 21:21
 */
public class BeanConvertor {

    public static <T,K> K convert(T source,Class<K> clazz){
        if (source == null || clazz == null){
            return null;
        }

        final BeanCopier copier = BeanCopier.create(source.getClass(),clazz, false);

        try {
            K instance = clazz.newInstance();
            copier.copy(source,instance,null);
            return instance;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static <T,K> List<K> batchConvert(List<T> source, Class<K> clazz){
        if (CollectionUtils.isEmpty(source) || clazz == null){
            return Lists.newArrayList();
        }
        List<K> result = Lists.newArrayList();
        source.forEach(t -> {
            K k = convert(t,clazz);
            result.add(k);
        });
        return result;
    }

    /**
     *
     * 功能描述: 实体类转map
     *
     * @param: Object obj
     * @return: Map
     * @auther: liqingsong
     * @date: 2019-02-21 19:38
     */
    public static Map<String, String> beanToMap(Object obj)  {
        if (obj == null){
            return null;
        }

        Map<String, String> maps = Maps.newConcurrentMap();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                maps.put(field.getName(), String.valueOf(field.get(obj)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        return maps;
    }

}
