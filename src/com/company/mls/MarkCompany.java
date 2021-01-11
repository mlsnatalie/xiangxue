package com.company.mls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MarkCompany implements InvocationHandler {

    private Object factory;

    public MarkCompany(Object factory) {
        this.factory = factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(), factory.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSthBefore();
        method.invoke(factory, args);
        doSthAfter();
        return null;
    }

    private void doSthBefore() {
        System.out.println("根据需求，进行市场调研和产品分析");
    }

    private void doSthAfter() {
        System.out.println("精美包装，快递一条龙服务");
    }
}
