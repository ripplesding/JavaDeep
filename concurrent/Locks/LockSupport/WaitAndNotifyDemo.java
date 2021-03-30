package Locks.LockSupport;



/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/30
 */
public class WaitAndNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        HisThread myThread = new HisThread();
        synchronized (myThread) {
            try {
                myThread.start();
                // 主线程睡眠3s
                Thread.sleep(3000);// sleep不释放锁
                System.out.println("before wait");
                // 阻塞主线程
                myThread.wait();// wait释放锁
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HisThread extends Thread {

    public void run() {
        synchronized (this) {
            System.out.println("before notify");
            notify();// 唤醒，但是main此时未获得锁
            System.out.println("after notify");
        }
    }
}
