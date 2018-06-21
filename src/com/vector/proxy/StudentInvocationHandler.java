package com.vector.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by DCITS-cs on 2018/6/22.
 */
public class StudentInvocationHandler<T> implements InvocationHandler {
    T target;

    public StudentInvocationHandler(T target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object obj = method.invoke(target,args);
        return obj;
    }
}
