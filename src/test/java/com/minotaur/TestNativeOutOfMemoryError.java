package com.minotaur;

import java.util.concurrent.CountDownLatch;

/**
 * ********************************
 * Created by minotaur on 2018/4/24. *
 * ********************************
 */
public class TestNativeOutOfMemoryError {

    public static void main(String[] args) {

        for (int i = 0;i<20000; i++) {
            System.out.println("i = " + i);
            new Thread(new HoldThread()).start();
        }
    }

}

class HoldThread extends Thread {
    CountDownLatch cdl = new CountDownLatch(1);

    public HoldThread() {
        this.setDaemon(true);
    }

    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
        }
    }
}
