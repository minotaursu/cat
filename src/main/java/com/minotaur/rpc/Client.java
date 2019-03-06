package com.minotaur.rpc;

import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * ********************************
 * Created by minotaur on 2019/3/1. *
 * ********************************
 */
public class Client {

    public static void main(String[] args) {
        testLocalRpc();
        testCglibLocalRpc();
        System.out.println(HelloWorld.class.getInterfaces());
        System.out.println(new Class[] { HelloWorld.class });
    }

    private static void testLocalRpc() {
        HelloWorld helloWorld = new HelloWorldImpl();
        LocalRpc localRpc = new LocalRpc(helloWorld);
        HelloWorld helloWorldProxy = (HelloWorld) Proxy.newProxyInstance(localRpc.getClass().getClassLoader(),
            helloWorld.getClass().getInterfaces(), localRpc);
        System.out.println(helloWorldProxy.sayHello("lily"));
    }

    private static void testCglibLocalRpc() {
        HelloWorld helloWorld = new HelloWorldImpl();
        CglibLocalRpc localRpc = new CglibLocalRpc(helloWorld);
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(localRpc);
        enhancer.setSuperclass(helloWorld.getClass());
        HelloWorld helloWorldProxy = (HelloWorld) enhancer.create();
        System.out.println(helloWorldProxy.sayHello("lily"));
    }
}
