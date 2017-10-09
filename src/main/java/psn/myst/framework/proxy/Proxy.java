package psn.myst.framework.proxy;

/**
 * @author huangrx
 * @version V1.0
 * @since 2017/9/30
 */
public interface Proxy {

    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
