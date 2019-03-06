package com.minotaur.rpc;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ********************************
 * Created by minotaur on 2019/3/1. *
 * ********************************
 */
public class CglibLocalRpc implements MethodInterceptor {

    private Object target;

    public CglibLocalRpc(Object object) {
        this.target = object;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = proxy.invoke(target, args);
        if (result instanceof String) {
            return "cglib proxy " + result;
        }
        return result;
    }
}
