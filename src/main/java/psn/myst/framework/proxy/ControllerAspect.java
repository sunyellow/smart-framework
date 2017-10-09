package psn.myst.framework.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/10/9
 */
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void begin(Class<?> cls, Method method, Object[] params) {
        LOGGER.debug("---------- begin ----------");
        LOGGER.debug(String.format("class : %s", cls.getName()));
        LOGGER.debug(String.format("method : %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug(String.format("time : %dms", System.currentTimeMillis() - begin));
        LOGGER.debug("---------- end ----------");
    }
}
