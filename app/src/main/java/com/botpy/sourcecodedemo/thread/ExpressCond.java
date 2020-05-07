package com.botpy.sourcecodedemo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 显示锁：Lock
 * 使用 Lock 和 Condition 实现等待通知机制
 * @author liuxuhui
 * @date 2020-04-17
 */
public class ExpressCond {
    private int km;
    private String site;
    private Lock lock = new ReentrantLock();
    private Condition kmCond = lock.newCondition();
    private Condition siteCond = lock.newCondition();

    public ExpressCond(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public ExpressCond() {

    }

    /**
     * 变化公里数，然后通知处于wait状态并需要处理公里数的线程进行业务处理
     * singal() 通知一个线程
     */
    public void changeKm() {
        lock.lock();
        try {
            this.km = 101;
            kmCond.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 变化地点，然后通知处于wait状态并需要处理地点的线程进行业务处理
     * singalAll() 通知所有的线程
     */
    public void changeSite() {
        lock.lock();
        try {
            this.site = "Beijing";
            kmCond.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitKm() {
        lock.lock();
        try {
            while (this.km < 100) {
                try {
                    kmCond.await();
                    System.out.println("check km thread[" + Thread.currentThread().getName() + "] is be notifyed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }
        System.out.println("this km is " + this.km + " ,i will change");
    }

    public void waitSite() {
        lock.lock();
        try {
            while ("Shanghai".equals(this.site)) {
                try {
                    siteCond.await();
                    System.out.println("check site thread[" + Thread.currentThread().getName() + "] is be notifyed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }
        System.out.println("this site is " + this.km + " ,i will change");
    }
}