package com.botpy.sourcecodedemo.thread;

/**
 * @author liuxuhui
 * @date 2020-04-08
 */
public class UseJoin {
    public static void main(String[] args) {
        Thread previous = Thread.currentThread();
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JumpQueue(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "terminate.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class JumpQueue implements Runnable{

        private Thread  thread;

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                System.out.println(thread.getName() + "will be join before " + Thread.currentThread().getName());
                thread.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "terminate");
        }
    }
}
