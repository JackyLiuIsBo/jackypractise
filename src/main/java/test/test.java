package test;/**
 * @program: jackypractise
 * @description:
 * @author: liubo
 * @date: 2022-01-08 16:53
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 @ClassName test
 @Description
 @Author liubo
 @Date 2022/1/8 下午4:53
 **/
public class test {
    public static void main(String[] args) {
        String jsonStr = "erro";
        Object object = JSON.parse(jsonStr);
        if (object instanceof JSONObject) {
            JSONObject jsonObject = (JSONObject) object;
        } else if (object instanceof JSONArray) {
            JSONArray jsonArray = (JSONArray) object;
        } else {
            System.out.println("jsonStr");
        }

    }
}
