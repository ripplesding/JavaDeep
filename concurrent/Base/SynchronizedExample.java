package Base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/23
 */
public class SynchronizedExample {
    public static void main(String[] args) {
        SynchronizedExample se1 = new SynchronizedExample();
        SynchronizedExample se2 = new SynchronizedExample();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(()->se1.func1());
        es.execute(()->se2.func1());
        es.shutdown();
    }
//    public void func1(){ // 同步一个代码块，只能同步同一个对象，同步方法同理
//        synchronized (this){
//            for(int i = 0; i < 10; i++){
//                System.out.print(i+" ");
//            }
//        }
//    }

    public synchronized static void func1(){ // 同步一个类，可以同步一个类的多个对象,同步静态方法同理
//        synchronized (SynchronizedExample.class){
            for(int i = 0; i < 10; i++){
                System.out.print(i+" ");
            }
//        }
    }
}
