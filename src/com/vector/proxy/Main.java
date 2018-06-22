package com.vector.proxy;

import net.sf.cglib.proxy.Enhancer;
import sun.misc.ProxyGenerator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by DCITS-cs on 2018/6/22.
 */
public class Main {
    public static void main(String[] args) {
        Person stu = new Student();

        //静态代理
        StudentProxy proxy = new StudentProxy(stu);
        proxy.giveMoney();


        //JDK动态代理
        InvocationHandler stuHandler = new StudentInvocationHandler<Person>(stu);
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),
                stu.getClass().getInterfaces(),stuHandler);
        stuProxy.giveMoney();

        //cglib
        StudentCglibProxy studentCglibProxy = new StudentCglibProxy();
        Enhancer enhance = new Enhancer();//作用是创建一段动态地类字节码
        enhance.setSuperclass(stu.getClass());
        enhance.setCallback(studentCglibProxy);
        Person stuCglibProxy = (Person) enhance.create();
        stuCglibProxy.giveMoney();


    }
}
