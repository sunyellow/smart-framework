package psn.myst.framework.helper;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import psn.myst.framework.annotation.Action;
import psn.myst.framework.bean.Handler;
import psn.myst.framework.bean.Request;
import psn.myst.framework.util.ClassUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/9/2
 */
public final class ControllerHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassHelper.class);

    private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtils.isNotEmpty(controllerClassSet)) {
            for (Class<?> controllerClass : controllerClassSet) {
                Method[] methods = controllerClass.getDeclaredMethods();
                if (ArrayUtils.isNotEmpty(methods)) {
                    for (Method method: methods) {
                        if (method.isAnnotationPresent(Action.class)) {
                            Action action = method.getAnnotation(Action.class);
                            String mapping = action.value();
                            //验证 URL 映射规则
                            if (mapping.matches("\\w+:/\\w+")) {
                                String[] array = mapping.split(":");
                                if (ArrayUtils.isNotEmpty(array) && array.length == 2) {
                                    String requestMethod = array[0];
                                    String requestPath = array[1];
                                    Request request = new Request(requestMethod, requestPath);
                                    Handler handler = new Handler(controllerClass, method);
                                    LOGGER.error("add to ACTION_MAP,  request : {},   handler : {}", request, handler);
                                    ACTION_MAP.put(request, handler);
                                }
                            }
                        }
                    }
                }
            }
        }
        LOGGER.error("finish ControllerHelper static.");
    }

    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        if (!ACTION_MAP.containsKey(request)) {
            throw new RuntimeException("can not get Handler by request :" + request);
        }
        return ACTION_MAP.get(request);
    }
}
