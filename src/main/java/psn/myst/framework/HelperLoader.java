package psn.myst.framework;

import psn.myst.framework.helper.AopHelper;
import psn.myst.framework.helper.BeanHelper;
import psn.myst.framework.helper.ClassHelper;
import psn.myst.framework.helper.ControllerHelper;
import psn.myst.framework.helper.IocHelper;
import psn.myst.framework.util.ClassUtil;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/9/2
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classeList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };

        for (Class<?> cls : classeList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
