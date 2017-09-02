package psn.myst.framework.bean;

import java.util.Map;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/9/2
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public Map<String, Object> getMap() {
        return paramMap;
    }
}
