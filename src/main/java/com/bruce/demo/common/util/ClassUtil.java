package com.bruce.demo.common.util;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author bruce
 * @date 2023/6/4
 * @desc 类工具
 */
public class ClassUtil {
    private ClassUtil() {
    }

    /**
     * 反射调用接口default方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public static Object invokeDefaultMethod(Object proxy, Method method, Object[] args) throws Throwable{
        if (method.isDefault()) {
            Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class
                    .getDeclaredConstructor(Class.class, int.class);
            constructor.setAccessible(true);

            Class<?> declaringClass = method.getDeclaringClass();
            int allModes = MethodHandles.Lookup.PUBLIC | MethodHandles.Lookup.PRIVATE | MethodHandles.Lookup.PROTECTED | MethodHandles.Lookup.PACKAGE;

            return constructor.newInstance(declaringClass, allModes)
                    .unreflectSpecial(method, declaringClass)
                    .bindTo(proxy)
                    .invokeWithArguments(args);
        }
        return null;
    }

}
