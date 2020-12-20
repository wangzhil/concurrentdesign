package developerwang.concurrent.executor;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangzhilei
 * @version V1.0
 * @Package developerwang.concurrent.executor
 * @description 数据行共享访问优化方式,解决多CPU间空想缓存行数据，互相通信性能问题。开源闪电源码，环形缓冲区就使用的此种方式，获得各种奖。
 * @date 2020/12/20 9:06
 * @Copyright © 2020-2021 sinosoft.com.cn
 */
public class ExecutorOpzationTest {

    static class T {
        long a1;long a2;long a3;long a4;long a5;long a6;long a7;
        public long x = 0L;
//        long a10;long a11;long a12;long a13;long a14;long a15;long a16;
    }

    static Long COUNT = 1000000000L;
    static T[] arr = new T[2];
    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }
            countDownLatch.countDown();
        }, "线程一");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                arr[1].x = i;
            }
            countDownLatch.countDown();
        }, "线程二");

        long start = System.nanoTime();

        t1.start();
        t2.start();
        countDownLatch.await();

        long end = System.nanoTime();
        System.out.println((end - start)/ 100000);
    }
}
