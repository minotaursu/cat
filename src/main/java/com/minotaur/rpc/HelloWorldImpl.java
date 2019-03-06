package com.minotaur.rpc;

/**
 * ********************************
 * Created by minotaur on 2019/3/1. *
 * ********************************
 */
public class HelloWorldImpl implements HelloWorld {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
