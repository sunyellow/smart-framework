package psn.myst.framework.helper;

import psn.myst.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/9/2
 */
public final class BeanHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object object = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, object);
        }
    }

    /**
     * 获取 Bean 映射
     * @return
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    public static  <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("can not get bean by class :" + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }
}
