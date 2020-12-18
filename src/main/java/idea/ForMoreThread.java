package idea;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: eclipse
 * @description: 多线程调试
 * @author: WangZhiLei
 * @create: 2020-10-19 09:05
 **/
public class ForMoreThread {

    public static void main(String[] args) {

        new Thread( () -> {
            System.out.println("11111111");
        }, "线程一").start();

        new Thread( () -> {
            System.out.println("22222222");
        }, "线程二").start();

        System.out.println("333333333");
        System.out.println("444444444");


        ThreadFactory namedThreadFactory = r -> new Thread(r, "线程一");
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }
}
