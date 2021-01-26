package com.company.mls.thread;

public class VolatileTest {
    public volatile int inc = 0;
    public void increase() {
        inc++;
    }

    public static void main(String[] str) {
        final VolatileTest test = new VolatileTest();
        for (int i=0; i < 10; i++) {
            new Thread(() -> {
                for (int j =0; j < 1000; j++) {
                    test.increase();
                }
            }).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(test.inc);
    }
}
