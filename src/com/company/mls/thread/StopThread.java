package com.company.mls.thread;

import java.util.concurrent.TimeUnit;

public class StopThread {

    public static void main(String[] str) throws InterruptedException {
        MoonRunnable moonRunnable = new MoonRunnable();
        Thread thread = new Thread(moonRunnable, "MoonThread");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(50);
        thread.interrupt();
    }

    public static class MoonRunnable implements Runnable {

        private long i;

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
                System.out.println("i=" + i);
            }
            System.out.println("Stop");
        }
    }
}
