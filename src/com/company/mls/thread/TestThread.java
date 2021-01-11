package com.company.mls.thread;

public class TestThread extends Thread {

    public void run() {
        System.out.println("Hello World!");
    }

    public static void main(String[] str) {
        Thread mThread = new TestThread();
        mThread.start();
    }
}
