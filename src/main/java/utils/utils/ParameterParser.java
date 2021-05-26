package utils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;

/**
 * 参数解析
 * 参数名带[]为String 数组
 * 参数名带[int]为int数组
 * 参数名以Int结尾为int
 *
 * @author gwq
 */
public class ParameterParser {
    private static final String LIST_CONDITION_NAME = "listConditions";
    public static final List<String> internalExcludes = new ArrayList<String>();

    static {
        internalExcludes.add("_csrf_token");
        internalExcludes.add("ticket");
        internalExcludes.add(LIST_CONDITION_NAME);
    }

    /**
     * 封装请求参数
     *
     * @param
     * @return 返回封装结果
     */
    /*public static <T> T assembleParas(T bean, HttpServletRequest request) {
        ServletRequestDataBinder binder = new ServletRequestDataBinder(bean);
        binder.registerCustomEditor(Date.class, new DateCovertor(true));
        binder.bind(request);
        return bean;
    }*/

    public static class DateCovertor extends CustomDateEditor {
        private static final String[] all_not_need_chars = {"-", "/", "\\", " ", ":"};

        public DateCovertor(boolean allowEmpty) {
            super(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), allowEmpty);
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            if (text != null) {

                for (int i = 0; i < all_not_need_chars.length; i++) {
                    text = text.replace(all_not_need_chars[i], "");
                }

                String pattern = "yyyyMMddHHmmss".substring(0, text.length());
                try {
                    setValue(new SimpleDateFormat(pattern).parse(text));
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Could not parse date: " + e.getMessage(), e);
                }
            }
        }

    }


    public static Map<String, Object> getParametersMapExcept(List<String> excludes, HttpServletRequest request) {
        List<String> allExcludes = new ArrayList<String>(internalExcludes);
        if (excludes != null) {
            allExcludes.addAll(excludes);
        }

        Map<String, Object> params = new HashMap<String, Object>();
        if (request != null) {
            List<String> listConditionNames = null;
            //这个值标识的参数，要组装成数组
            String listConditionNameString = request.getParameter(LIST_CONDITION_NAME);
            if (listConditionNameString != null && !listConditionNameString.trim().equals("")) {
                listConditionNames = removeDuplicate(Arrays.asList(listConditionNameString.split(",")));
            }

            @SuppressWarnings("unchecked")
            Enumeration<String> names = request.getParameterNames();


            while (names.hasMoreElements()) {
                String name = (String) names.nextElement();
                if (isExceptParam(name, allExcludes)) {
                    continue;
                }
                if (listConditionNames != null && listConditionNames.contains(name)) {
                    //封装成List
                    String[] value = request.getParameterValues(name);
                    if (value != null && value.length > 0) {
                        params.put(name, removeDuplicate(Arrays.asList(value)));
                    }
                } else {
                    String[] parameterValues = request.getParameterValues(name);

                    //普通字符串
                    if (parameterValues != null && parameterValues.length == 1) {
                        if (parameterValues[0] != null && !"".equals(parameterValues[0].trim())) {
                            params.put(name, parameterValues[0].trim());
                        }
                    } else {
                        if (parameterValues != null && parameterValues.length > 0) {
                            params.put(name, removeDuplicate(Arrays.asList(parameterValues)));
                        }
                    }
                }

            }
        }
        return params;
    }

    private static List<String> removeDuplicate(List<String> src) {
        if (src == null) {
            return null;
        }
        Set<String> set = new HashSet<String>(src);
        return new ArrayList<String>(set);
    }

    private static boolean isExceptParam(String paramName, List<String> exludes) {
        return (exludes != null && exludes.contains(paramName));
    }
}
