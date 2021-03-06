package psn.myst.framework.bean;

import java.lang.reflect.Method;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/9/2
 */
public class Handler {

    /**
     * Controller类
     */
    private Class<?> controllerClass;

    /**
     * Action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }

    @Override
    public String toString() {
        return "Handler{" +
                "controllerClass=" + controllerClass.getName() +
                ", actionMethod=" + actionMethod.getName() +
                '}';
    }
}
