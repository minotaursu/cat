package com.minotaur.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * ********************************
 * Created by minotaur on 2019/3/1. *
 * ********************************
 */
public class LocalRpc implements InvocationHandler {

    private Object target;

    public LocalRpc(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(target, args);
        if (result instanceof String) {
            return "proxy " + result;
        }
        return result;
    }
}
