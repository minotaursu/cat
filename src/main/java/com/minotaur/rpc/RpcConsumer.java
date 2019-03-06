package com.minotaur.rpc;

/**
 * ********************************
 * Created by minotaur on 2019/3/4. *
 * ********************************
 */
public class RpcConsumer {

    public static void main(String[] args) {
        HelloWorld service = RpcFramework.refer(HelloWorld.class, "127.0.0.1", 9997);
        for (int i = 0; i < 10; i++) {
            String result = service.sayHello("lily" + i);
            System.out.println(result);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
