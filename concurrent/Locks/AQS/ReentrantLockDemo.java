package Locks.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/31
 */
public class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {
        Depot depot = new Depot(500);
        new Producer(depot).produce(500);// emptyCondition.signal()
        new Producer(depot).produce(200);// fullCondition.await()    emptyCondition.signal()
        new Consumer(depot).consume(500);// fullCondition.signal()
        new Consumer(depot).consume(200);// emptyCondition.await()
    }
}

class Depot {
    private int size;
    private int capacity;
    private Lock lock;
    private Condition fullCondition;// 满条件
    private Condition emptyCondition;// 空条件

    public Depot(int capacity) {// 构造函数
        this.capacity = capacity;
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void produce(int no) {
        lock.lock();
        int left = no;
        try {
            while (left > 0) {
                while (size >= capacity)  {
                    System.out.println(Thread.currentThread() + " before await");
                    fullCondition.await();
                    System.out.println(Thread.currentThread() + " after await");
                }
                int inc = (left + size) > capacity ? (capacity - size) : left;
                left -= inc;
                size += inc;
                System.out.println("produce = " + inc + ", size = " + size);
                emptyCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int no) {
        lock.lock();
        int left = no;
        try {
            while (left > 0) {
                while (size <= 0) {
                    System.out.println(Thread.currentThread() + " before await");
                    emptyCondition.await();
                    System.out.println(Thread.currentThread() + " after await");
                }
                int dec = (size - left) > 0 ? left : size;
                left -= dec;
                size -= dec;
                System.out.println("consume = " + dec + ", size = " + size);
                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class Consumer {
    private Depot depot;
    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consume(int no) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                depot.consume(no);
            }
        }, no + " consume thread").start();
    }
}

class Producer {
    private Depot depot;
    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(int no) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                depot.produce(no);
            }
        }, no + " produce thread").start();
    }
}