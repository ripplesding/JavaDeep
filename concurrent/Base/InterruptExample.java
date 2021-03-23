package Base;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/23
 */
public class InterruptExample {
    public static void main(String[] args) {
        Thread thread1 = new MyThread1();
        thread1.start();
        thread1.interrupt();
        System.out.println("Main run");
    }

    private static class MyThread1 extends Thread {
        @Override
        public void run() {
//            try {
//                Thread.sleep(2000);
//                System.out.println("Thread run");
//            } catch (InterruptedException e) {
////                e.printStackTrace();
//                System.out.println("Exception!");
//            }
            while(!interrupted()){
                System.out.println("1");
            }
            System.out.println("Thread end.");
        }
    }
}

