package psn.myst.framework.helper;

import org.apache.commons.lang3.ArrayUtils;
import psn.myst.framework.annotation.Inject;
import psn.myst.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/9/2
 */
public final class IocHelper {

    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
            //获取bean类与实例
            Class<?> beanClass = beanEntry.getKey();
            Object beanInstance = beanEntry.getValue();

            //获取 Bean 类定义的所有成员变量
            Field[] beanFields = beanClass.getFields();
            if (ArrayUtils.isNotEmpty(beanFields)) {
                for (Field beanField : beanFields) {
                    if (beanField.isAnnotationPresent(Inject.class)) {
                        Class<?> beanFieldClass = beanField.getType();
                        Object beanFiledInstance = beanMap.get(beanFieldClass);
                        if (beanFiledInstance != null) {
                            ReflectionUtil.setField(beanInstance, beanField, beanFiledInstance);
                        }
                    }
                }
            }
        }
    }
}
