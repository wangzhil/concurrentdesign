package tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: eclipse
 * @description: 阿里规约插件好处演示
 * @author: WangZhiLei
 * @create: 2020-11-12 21:04
 **/
public class ForAlibabaJavaGuidLine {

    public static void main(String[] args) {
        Thread t = new Thread( () -> {
            System.out.println("我就要创建一个单纯的线程!");
        }, "线程一");



        ThreadFactory namedThreadFactory = (r) -> new Thread(r, "demo-pool-%d");
        ExecutorService singleThreadPool = new ThreadPoolExecutor(5, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        singleThreadPool.execute(()-> System.out.println("我就要创建一个单纯的线程!"));
        singleThreadPool.shutdown();
    }
}
