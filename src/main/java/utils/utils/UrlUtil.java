package utils.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wuxiaochao
 * @Description //URL  参数解析
 * @date 2020/12/10 4:49 AM
 */
public class UrlUtil {
    public static class UrlEntity {
        /**
         * 基础url
         */
        public String baseUrl;
        /**
         * url参数
         */
        public Map<String, String> params;
    }

    /**
     * 解析url
     *
     * @param url
     * @return
     */
    public static UrlEntity parse(String url) {
        UrlEntity entity = new UrlEntity();
        if (url == null) {
            return entity;
        }
        url = url.trim();
        if (url.equals("")) {
            return entity;
        }
        String[] urlParts = url.split("\\?");
        entity.baseUrl = urlParts[0];
        //没有参数
        if (urlParts.length == 1) {
            return entity;
        }
        //有参数
        String[] params = urlParts[1].split("&");
        entity.params = new HashMap<>();
        for (String param : params) {
            String[] keyValue = param.split("=");
            entity.params.put(keyValue[0], keyValue[1]);
        }

        return entity;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            String url = "https://ilce.alicdn.com/montage/160553-95343c9e56b1fb655d88f6a180068ac2.jpg?content=%7B%2224%22%3A%7B%22attrs%22%3A%7B%22value%22%3A%22%E8%B6%85%E5%80%BC%E5%AE%9E%E6%83%A0%EF%BC%81%E5%BA%97%E9%95%BF%E6%8E%A8%E8%8D%90%EF%BC%81%22%7D%7D%2C%2215%22%3A%7B%22attrs%22%3A%7B%22mini%22%3Afalse%2C%22value%22%3A%22https%3A%2F%2Fimg.alicdn.com%2Fimgextra%2Fi1%2F2200779050892%2FO1CN011ISZts7hqSxxvhJ_%21%212200779050892-0-koubei.jpg%22%7D%7D%2C%2227%22%3A%7B%22attrs%22%3A%7B%22value%22%3A%22%E5%93%81%E7%89%8C%E5%BA%97%E5%8A%9F%E8%83%BD%E9%AA%8C%E8%AF%81%28%E9%AA%8C%E6%94%B6%29%22%7D%7D%2C%2219%22%3A%7B%22attrs%22%3A%7B%22value%22%3A%22%E7%82%B9%E5%87%BB%E6%9F%A5%E7%9C%8B%22%7D%7D%2C%2230%22%3A%7B%22attrs%22%3A%7B%22value%22%3A%22%E4%BD%99%E6%9D%AD%E5%8C%BA+%E7%BE%8E%E9%A3%9F+%E5%A5%BD%E5%BA%97%E6%8E%A8%E8%8D%90%22%7D%7D%7D&channel=72";
            url = url.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            UrlEntity entity = parse(URLDecoder.decode(url,"UTF-8"));
            System.out.println(entity.baseUrl + "\n" + entity.params);

            String content = "{\"24\":{\"attrs\":{\"value\":\"超值实惠！店长推荐！\"}},\"15\":{\"attrs\":{\"mini\":false,"
                + "\"value\":\"https://img.alicdn"
                + ".com/imgextra/i1/2200779050892/O1CN011ISZts7hqSxxvhJ_!!2200779050892-0-koubei.jpg\"}},"
                + "\"27\":{\"attrs\":{\"value\":\"品牌店功能验证(验收)\"}},\"19\":{\"attrs\":{\"value\":\"点击查看\"}},"
                + "\"30\":{\"attrs\":{\"value\":\"余杭区 美食 好店推荐\"}}}";

            JSONObject jsonObject = JSONObject.parseObject(content);
            Map<String, Object> map = jsonObject.getInnerMap();
            Object object = jsonObject.get("attrs");
            System.out.println(object);


        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
