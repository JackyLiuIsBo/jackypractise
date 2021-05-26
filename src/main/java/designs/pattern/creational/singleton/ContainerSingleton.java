package designs.pattern.creational.singleton;


import java.util.HashMap;
import java.util.Map;

import com.aliyun.opensearch.sdk.dependencies.org.apache.commons.lang.StringUtils;

/**
 * Created by geely
 */
public class ContainerSingleton {

    private ContainerSingleton(){

    }
    private static Map<String,Object> singletonMap = new HashMap<String,Object>();

    public static void putInstance(String key,Object instance){
        if(StringUtils.isNotBlank(key) && instance != null){
            if(!singletonMap.containsKey(key)){
                singletonMap.put(key,instance);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }


}
