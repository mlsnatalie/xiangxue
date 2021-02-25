package cn.enjoyedu.concurrent.threadpool;

import cn.enjoyedu.concurrent.tools.SleepTools;

import java.util.Random;
import java.util.concurrent.*;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：线程池的使用
 */
public class UseThreadPool {
	//工作线程
    static class Worker implements Runnable
    {
        private String taskName;
        private Random r = new Random();

        public Worker(String taskName){
            this.taskName = taskName;
        }

        public String getName() {
            return taskName;
        }

        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName()
            		+" process the task : " + taskName);
            SleepTools.ms(r.nextInt(100)*5);
        }
    }
    
    static class CallWorker implements Callable<String>{
    	
        private String taskName;
        private Random r = new Random();

        public CallWorker(String taskName){
            this.taskName = taskName;
        }

        public String getName() {
            return taskName;
        }    	

		@Override
		public String call() throws Exception {
            System.out.println(Thread.currentThread().getName()
            		+" process the task : " + taskName);
            return Thread.currentThread().getName()+":"+r.nextInt(100)*5;
		}
    	
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        //TODO
    }
}
