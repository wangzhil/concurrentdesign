package idea;

import java.util.HashMap;

/**
 * @program: eclipse
 * @description:
 * @author: WangZhiLei
 * @create: 2020-10-27 18:36
 **/
public class JavaTest {
    public static void main(String[] args) {
        HashMap hashmap = new HashMap();
        int i = 1;
        System.out.println(i -- + "");
        System.out.println((i --) + "");
    }
    public void test() {
        System.out.println("public is not default final !");
    }

    private void test1() {
        System.out.println("private is default final !");
    }
}
