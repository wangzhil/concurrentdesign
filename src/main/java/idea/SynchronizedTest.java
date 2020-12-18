package idea;

/**
 * @program: eclipse
 * @description: Synchronized Demo
 * @author: WangZhiLei
 * @create: 2020-10-22 09:45
 **/
public class SynchronizedTest {

    public static void main(String[] args) {

        System.out.println("1");
        synchronized (SynchronizedTest.class) {
            System.out.println("2");
            System.out.println("3");
            System.out.println("4");
            System.out.println("5");
        }
        System.out.println("6");

    }

    public synchronized void SynTest() {
        System.out.println("33333333333333333333");
    }
}
