package com.botpy.sourcecodedemo.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * Thread 是对线程的抽象
 * Runnable 和 Callable 只是对任务的抽象，并不会启动一个线程。
 *
 * 开启子线程的三种方式
 * @author liuxuhui
 * @date 2020-04-07
 */
public class NewThread {
    private final static String TAG = "NewThread";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread = new UseThread();
        thread.start();

        new Thread(new UseRun()).start();
        FutureTask futureTask = new FutureTask<String>(new UseCall());
        new Thread(futureTask).start();

        System.out.println((String) futureTask.get());
    }

    /**
     * 实现 Callable 接口，允许有返回值
     * @return
     */
    private static class UseCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("实现 Callable 接口");
            return "Callable 的返回值";
        }
    }

    /**
     * 实现 Runnable 接口，重写 run 方法，创建子类对象，作为参数传递给 Thread 对象，调用 start 方法
     */
    private static class UseRun implements Runnable{

        @Override
        public void run() {
            System.out.println("实现 Runnable 接口");
        }
    }

    /**
     * 创建 Thread 类,重写 run 方法，调用 start() 方法
     */
    private static class UseThread extends Thread {
        @Override
        public void run() {
            System.out.println("继承 Thread 抽象类;isInterrupted:" + isInterrupted());
            if(!isInterrupted()) {
                interrupt();
                System.out.println("继承 Thread 抽象类;isInterrupted:" + isInterrupted());
            }
        }
    }
}
