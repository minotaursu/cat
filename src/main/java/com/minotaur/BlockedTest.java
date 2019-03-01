package com.minotaur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by minotaur on 15/7/17.
 */
public class BlockedTest {

    public static void main(String[] args) {

        ExecutorService executors= Executors.newFixedThreadPool(10);
        Long s=System.currentTimeMillis();
        for (int i=0;i<10*1000;i++) {
            final int finalI = i;
            executors.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        A.getInstance(finalI);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            });
        }
        executors.shutdown();
        while (!executors.isTerminated()){
        }
        Long e=System.currentTimeMillis();
        System.out.println(e-s+" :ms");
    }

}

class A{

    public A(B b){

    }

    public static A getInstance(int i) throws InterruptedException {
        return new A(B.getInstance(i));
    }
}

class B{

    public B(int i){
        System.out.println(i);
    }
    public static synchronized B getInstance(int i) throws InterruptedException {
        Thread.sleep(10);
        return new B(i);
    }
}