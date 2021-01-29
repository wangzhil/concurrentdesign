package syc;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzhilei
 * @version V1.0
 * @Package syc
 * @description
 * @date 2020/12/23 8:46
 * @Copyright © 2020-2021 sinosoft.com.cn
 */
public class S0 {

    public static void main(String[] args) {
        S0 so = new S0();
        so.doing();
    }

    public void doing() {
        S0 s = new S0();
        Thread t1 = new Thread(() -> {
            try {
                s.test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                s.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

    public synchronized void test() throws InterruptedException {
        System.out.println("test方法：线程 ：" + Thread.currentThread().getName() + " 进入");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("test方法：线程 ：" + Thread.currentThread().getName() + " 退出");
    }


    public synchronized void test2() throws InterruptedException {
        System.out.println("test2方法：线程 ：" + Thread.currentThread().getName() + " 进入");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("test2方法：线程 ：" + Thread.currentThread().getName() + " 退出");
    }

    class TestRunnable implements Runnable {
        @Override
        public void run() {
            try {
                test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
