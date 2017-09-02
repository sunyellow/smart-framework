package psn.myst.framework.bean;

import java.util.Map;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/9/2
 */
public class View {

    /**
     * 视图路径
     */
    private String path;

    /**
     * 模型数据
     */
    private Map<String, Object> model;

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
