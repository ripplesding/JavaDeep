package Atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/30
 */
public class AtomicArrayDemo {
    public static void main(String[] args) {

        AtomicIntegerArray array = new AtomicIntegerArray(new int[] { 1, 0 });
        System.out.println(array);
        System.out.println(array.getAndAdd(0, 2));// 按照索引增加delta
        System.out.println(array);
    }
}
