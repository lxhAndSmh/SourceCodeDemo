package com.botpy.sourcecodedemo.thread;

/**
 * @author liuxuhui
 * @date 2020-04-17
 */
public class TestCond {
    private static ExpressCond expressCond = new ExpressCond();

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 3; i++) {
            new CheckKm().start();
        }
        for(int i = 0; i < 3; i++) {
            new CheckSite().start();
        }

        Thread.sleep(1000);
        expressCond.changeKm();
    }

    private static class CheckKm extends Thread{
        @Override
        public void run() {
            expressCond.waitKm();
        }
    }

    private static class CheckSite extends Thread{
        @Override
        public void run() {
            expressCond.waitSite();
        }
    }
}
