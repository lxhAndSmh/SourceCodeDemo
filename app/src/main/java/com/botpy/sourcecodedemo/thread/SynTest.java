package com.botpy.sourcecodedemo.thread;

/**
 * @author liuxuhui
 * @date 2020-04-09
 */
public class SynTest {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private void incCount() {
        count++;
    }

    public static void main(String[] args) {
        new CountThread(new SynTest()).start();
        new CountThread(new SynTest()).start();
    }

    private static class CountThread extends Thread {
        private SynTest synTest;

        public CountThread(SynTest synTest) {
            this.synTest = synTest;
        }

        @Override
        public void run() {
            synTest.incCount();
        }
    }
}
