package com.company.test.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2016/7/28.
 */
public class Base implements Interface{
    @Override
    public void showInfo() {
        System.out.println("This is :" + this.getClass());
    }

    public static void main(String[] args) {
//        new Base().showInfo();
//        System.out.println("################");
//        new BaseProxy(new Base()).showInfo();
        Base base = new Base();
        base.showInfo();
        System.out.println("######################################");
        Interface in = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] {Interface.class},
                new MyInvocationHandler(base)
        );
        in.showInfo();
        System.out.println(in.getClass());
    }
}
