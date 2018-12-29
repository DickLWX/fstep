package com.dick.fstep.test.thread;

// 在指定条件下使线程停止执行
public class Thread04 {

    public static void main(String[] args) {

        MyRunnableStop myRunnable = new MyRunnableStop();
        Thread thread = new Thread(myRunnable);

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                thread.start();
            }
            if(i == 40){
                myRunnable.stopThread();
            }
        }
    }
}


class MyRunnableStop implements Runnable {

    private boolean stop;

    @Override
    public void run() {
        for (int i = 0; i < 100 && !stop; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public void stopThread() {
        this.stop = true;
    }

}

// lock 对象同步锁
/*
class X {

    // 显示定义Lock同步锁对象，此对象与共享资源具有一对一关系
    private final Lock lock = new ReentrantLock();

    public void m(){
        // 加锁
        lock.lock();

        //...  需要进行线程安全同步的代码

        // 释放Lock锁
        lock.unlock();
    }

}*/
