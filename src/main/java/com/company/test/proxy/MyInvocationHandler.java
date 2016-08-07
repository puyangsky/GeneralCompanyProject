package com.company.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/7/29.
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object proxie;
    public MyInvocationHandler(Object proxie) {
        this.proxie = proxie;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy function>>>>" + proxy.getClass() + ", method: " +
        method + ", args: " + args);
        return method.invoke(proxie, args);
    }
}
