package com.company.mls.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable {

    public static class MyTestCallable implements Callable {

        @Override
        public Object call() throws Exception {
            Thread.sleep(3000);
            return "Hello World!!!";
        }
    }

    public static void main(String[] str) {
        MyTestCallable myTestCallable = new MyTestCallable();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(myTestCallable);
        try {
            //但调用 Future的get（）方法以获取结果时，当前 线程就会阻塞，直到call（）方法返回结果。
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
