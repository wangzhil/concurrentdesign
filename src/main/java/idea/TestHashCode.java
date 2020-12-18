package idea;

/**
 * @author wangzhilei
 * @version V1.0
 * @Package idea
 * @description
 * @date 2020/12/2 8:38
 * @Copyright © 2020-2021 sinosoft.com.cn
 */
public class TestHashCode {

    public static void main(String[] args) {
        breakM();
    }

    private static void breakM() {
        LockBean lock = new LockBean();
        int a = lock.hashCode();
        synchronized (lock) {
            int b = lock.hashCode();
        }
        int c = lock.hashCode();
        int d  = 32;
    }
}
