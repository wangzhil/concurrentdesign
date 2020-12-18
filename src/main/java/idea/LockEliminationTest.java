package idea;

/**
 * @program: eclipse
 * @description: eliminationTest
 * @author: WangZhiLei
 * @create: 2020-10-22 09:14
 **/
public class LockEliminationTest {

    public String concatString(String s1, String s2, String s3) {
        return s1 + s2 + s3;
    }

    public static void main(String[] args) {
        LockEliminationTest lockEliminationTest = new LockEliminationTest();
        String str = lockEliminationTest.concatString("1", "2", "3");
    }
}
