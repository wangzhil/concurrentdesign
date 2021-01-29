package developerwang.concurrent.executor;

/**
 * @author wangzhilei
 * @version V1.0
 * @Package developerwang.concurrent.executor
 * @description
 * @date 2020/12/21 9:15
 * @Copyright © 2020-2021 sinosoft.com.cn
 */
public class VisibilityTest {


    static volatile int a  = 20;

    public static void main(String[] args) throws InterruptedException {
        a  = 20;

        new Thread(() -> {
            a = 30;
            System.out.println(a);
        }).start();

        Thread.sleep(1000);
        System.out.println(a);

    }
}
