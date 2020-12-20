package developerwang.concurrent.executor;

import java.util.concurrent.CountDownLatch;

/**
 * @author wangzhilei
 * @version V1.0
 * @Package developerwang.concurrent.executor
 * @description   测试原子的有序性问题
 * @date 2020/12/20 12:19
 * @Copyright © 2020-2021 sinosoft.com.cn
 */
public class ExecutionOrderLinessTest {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        // 此代码要放最外层，将无用。此处将无用。
//        CountDownLatch latch = new CountDownLatch(2);
        for (long i = 0; i < Integer.MAX_VALUE; i++) {

            // 此代码要放最外层，将无用。
            CountDownLatch latch = new CountDownLatch(2);
            a = 0; b = 0; x = 0; y = 0;
            Thread t = new Thread(() -> {
                a = 1;
                x = b;
                // 注意此代码可以起到通知其他线程同步数据作用
                latch.countDown();

            }, "t1");

            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
                // 注意此代码可以起到通知其他线程同步数据作用
                latch.countDown();
            }, "t2");

            t.start();
            t2.start();
            // 注意此代码可以起到通知其他线程同步数据作用
            latch.await();
            if ( x == 0 && y == 0) {
                System.out.println("第 -- " + i + " -- 次 完成!");
                break;
            }
        }
    }

}
