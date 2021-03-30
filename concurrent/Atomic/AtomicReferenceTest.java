package Atomic;


import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/30
 */
public class AtomicReferenceTest {
    public static void main(String[] args){

        // 创建两个Human对象，它们的id分别是101和102。
        Human p1 = new Human(101);
        Human p2 = new Human(102);
        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference ar = new AtomicReference(p1);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        ar.compareAndSet(p1, p2);

        Human p3 = (Human)ar.get();
        System.out.println("p3 is "+p3);
        System.out.println("p3.equals(p1)="+p3.equals(p1));
    }
}

class Human {
    volatile long id;
    public Human(long id) {
        this.id = id;
    }
    public String toString() {
        return "id:"+id;
    }
}