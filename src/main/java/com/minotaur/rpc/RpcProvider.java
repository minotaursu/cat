package com.minotaur.rpc;

import java.io.IOException;

/**
 * ********************************
 * Created by minotaur on 2019/3/4. *
 * ********************************
 */
public class RpcProvider {

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorldImpl();
        try {
            RpcFramework.export(helloWorld, 9997);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
