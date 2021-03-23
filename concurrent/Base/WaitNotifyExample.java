package Base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/23
 */
public class WaitNotifyExample {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample example = new WaitNotifyExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
    }

    public synchronized void before() {
        System.out.println("before");
        notifyAll();
    }

    public synchronized void after() {
        try {
            wait();// 先等一手notify
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }
}
