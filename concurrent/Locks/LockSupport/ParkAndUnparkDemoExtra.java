package Locks.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/30
 */
public class ParkAndUnparkDemoExtra {
    public static void main(String[] args) {
        MyThread myThread = new MyThread(Thread.currentThread());
        myThread.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");// unpark给这个提前解锁
        System.out.println("after park");
    }
}

class MyThread extends Thread {
    private Object object;

    public MyThread(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        // 释放许可
        LockSupport.unpark((Thread) object);
        System.out.println("after unpark");
    }
}
