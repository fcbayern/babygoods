package cn.babygoods.common;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Vincent on 2017/3/29.
 */
public class BeanUtil {
    public static Map beanToMap(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, String> hashMap = new HashMap<>();
        for (Field field : fields) {
            String fieldName = field.getName();
            String fieldValue = "";
            String name = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            String type = field.getGenericType().toString();
            Method method = object.getClass().getMethod("get" + name);
            switch (type) {
                case "class.java.lang.String":
                    String stringValue = (String) method.invoke(object);
                    if (stringValue != null) {
                        fieldValue = stringValue;
                    }
                    break;
                case "class.java.lang.Integer":
                    Integer integerValue = (Integer) method.invoke(object);
                    if (integerValue != null) {
                        fieldValue = integerValue.toString();
                    }
                    break;
                case "class.java.lang.Short":
                    Short shortValue = (Short) method.invoke(object);
                    if (shortValue != null) {
                        fieldValue = shortValue.toString();
                    }
                    break;
                case "class.java.lang.Double":
                    Double doubleValue = (Double) method.invoke(object);
                    if (doubleValue != null) {
                        fieldValue = doubleValue.toString();
                    }
                    break;
                case "class.java.lang.Boolean":
                    Boolean booleanValue = (Boolean) method.invoke(object);
                    if (booleanValue != null) {
                        fieldValue = booleanValue.toString();
                    }
                    break;
            }
            hashMap.put(fieldName, fieldValue);
        }

        return hashMap;
    }

    public static <T, S> T copyProperties(S source, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        try {
            BeanUtils.copyProperties(target, source);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
        }
        return target;
    }

    public static <T, S> List<T> copyProperties(List<S> sourceList, Class<T> targeClass) {
        List<T> targetList = new ArrayList<>();
        for (S s : sourceList) {
            T t = copyProperties(s, targeClass);
            targetList.add(t);
        }
        return targetList;
    }
}
