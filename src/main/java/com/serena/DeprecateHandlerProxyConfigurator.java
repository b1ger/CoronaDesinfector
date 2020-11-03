package com.serena;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DeprecateHandlerProxyConfigurator implements ProxyConfigurator {

    @Override
    public Object replaceWithProxyIfNeeded(Object t, Class implClass) {

        if (implClass.getInterfaces().length == 0) {
            return Enhancer.create(implClass, (net.sf.cglib.proxy.InvocationHandler) (o, method, objects) -> {
                return getInvocationHandlerLogic(t, method, objects);
            });
        }

        if (implClass.isAnnotationPresent(Deprecated.class)) {

            return Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> {
                return getInvocationHandlerLogic(t, method, args);
            });

        } else {
            return t;
        }
    }

    private Object getInvocationHandlerLogic(Object t, Method method, Object[] args) throws IllegalAccessException, InvocationTargetException {
        System.out.println("************** What are you doing, deprecated class **************");
        return method.invoke(t, args);
    }
}
