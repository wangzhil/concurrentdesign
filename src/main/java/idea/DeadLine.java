package idea;

/**
 * @program: eclipse
 * @description: TestDeadSynchronized
 * @author: WangZhiLei
 * @create: 2020-11-12 08:56
 **/
public class DeadLine {

    public static Object source1 = new Object();
    public static Object source2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (source1) {
                System.out.println("111111111111111111");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (source2) {
                    System.out.println("22222222222222222222222");
                }
                System.out.println("3333333333333333333333333");
            }
        }, "thread1").start();

        new Thread(() -> {
            synchronized (source2) {
                System.out.println("44444444444444444444444444");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (source1) {
                    System.out.println("5555555555555555555555555555555");
                }
                System.out.println("66666666666666666666666666666666666");
            }
        }, "thead2").start();
    }
}
