package Locks.LockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/30
 */
public class InterruptDemo {
    public static void main(String[] args) {
        OurThread myThread = new OurThread(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");

    }
}

class OurThread extends Thread {
    private Object object;

    public OurThread(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before interrupt");
        try {
            // 休眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = (Thread) object;
        // 中断线程
        thread.interrupt();
        System.out.println("after interrupt");
    }
}