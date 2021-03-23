package Base;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/23
 */
public class ThreadUseMethods {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("12");
            }
        });
        FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 123;
            }
        });
        Thread thread2 = new Thread(ft);
//        Thread thread2 = new Thread(new FutureTask<Integer>(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 123;
//            }
//        }));
        Thread thread3 = new MyThread1();

        thread1.start();
        thread2.start();
        System.out.println(ft.get());
        thread3.start();

    }
}
class MyThread1 extends Thread{
    @Override
    public void run(){
        System.out.println("1234");
    }
}
