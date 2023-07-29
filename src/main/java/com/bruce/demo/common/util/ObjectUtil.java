package com.bruce.demo.common.util;

import java.lang.reflect.Field;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 对象处理工具
 */
public class ObjectUtil {
    private ObjectUtil() {
    }

    /**
     * 去字符串前后空格
     * @param o
     */
    public static void dealStringTrim(Object o)   {
        if (o == null) {
            return;
        }
        Class<?> aClass = o.getClass();
        Field[] fields = aClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(o);
                if (field.getType() == String.class && value != null){
                    String s = (String) value;
                    field.set(o, s.trim());
                }
                field.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
