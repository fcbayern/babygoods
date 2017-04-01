package cn.babygoods.common;

import net.sf.json.JSONObject;

/**
 * Created by Vincent on 2017/3/29.
 */
public class JsonUtil {
    public static <T> T jsonToBean(String jsonString, Class<T> beanClass) {
        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        T bean = (T) JSONObject.toBean(jsonObject, beanClass);
        return bean;
    }

    public static String beanToJson(Object object) {
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }
}
