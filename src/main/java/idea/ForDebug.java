package idea;

/**
 * @program: eclipse
 * @description: idea的一些强大debug小技巧
 * @author: WangZhiLei
 * @create: 2020-10-19 08:45
 **/
public class ForDebug {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            method1(i);
        }

    }

    private static void method1(int i) {
        int y = i * 10;
        System.out.println(i);
        method2(i);
    }

    private static void method2(int i) {
        System.out.println(i);
    }


}
