package com.company.mls.thread;

public class TestRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World...");
    }

    public static void main(String[] str) {
        TestRunnable mTestRunnable = new TestRunnable();
        Thread thread = new Thread(mTestRunnable);
        thread.start();
    }
}
