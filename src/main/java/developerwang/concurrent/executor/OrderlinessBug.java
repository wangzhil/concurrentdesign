package developerwang.concurrent.executor;

import java.io.IOException;

/**
 * @author wangzhilei
 * @version V1.0
 * @Package developerwang.concurrent.executor
 * @description
 * @date 2020/12/20 16:38
 * @Copyright © 2020-2021 sinosoft.com.cn
 */
public class OrderlinessBug {
    static int m  = 9;

    public OrderlinessBug() {

        // 不能构造方法里面写逻辑或者启动线程。不然很容易出现还在半初始化状态使用值。可能输出结果为0.同DCL 是否加volatile一个意思。
        new Thread(() -> {
            System.out.println(m);
        }).start();
    }

    public static void main(String[] args) throws IOException {
        new OrderlinessBug();
        System.in.read();
    }

}
