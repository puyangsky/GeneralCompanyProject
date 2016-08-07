package com.company.test.proxy;

/**
 * Created by Administrator on 2016/7/28.
 */
public class BaseProxy implements Interface{
    private Interface in;
    public BaseProxy(Interface in) {
        this.in = in;
    }

    @Override
    public void showInfo() {
        System.out.println("This is :" + this.getClass());
        in.showInfo();
    }
}
