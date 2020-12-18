package developerwang.concurrent.executor;

import java.time.LocalDateTime;

/**
 * @author zhaozheng
 * @date 2020/12/16 3:34 下午
 */
public class Demo {
    String name = "zhangsan";

    public void setName() {
        name = "lisi";
    }

    public static void main(String[] args) {
        Demo aDemo = new Demo();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"---"+LocalDateTime.now() + ":" + aDemo.name);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            aDemo.setName();

            System.out.println(Thread.currentThread().getName()+"---"+LocalDateTime.now() + ":" + aDemo.name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();

        /*new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+"---"+LocalDateTime.now() + ":" + aDemo.name);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"---"+LocalDateTime.now() + ":" + aDemo.name);
        }, "线程2").start();*/

        while (aDemo.name.equals("zhangsan")) {

        }
        System.out.println("over");
    }
}
