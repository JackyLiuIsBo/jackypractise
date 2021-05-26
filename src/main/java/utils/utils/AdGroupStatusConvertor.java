package utils.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangtingbang
 * @email: tingbang.wtb@alibaba-inc.com/tingbang.wang@ele.me
 * @Date: 2019-02-26 22:12
 * @Description: TODO
 */

public class AdGroupStatusConvertor {

    private static final Map<Integer, String> ONLINE_STATE_MAP = new HashMap(2) {{
        put(0, "下线");
        put(1, "上线");
    }};

    public static String nameOf(int code) {
        return ONLINE_STATE_MAP.get(code);
    }
}
