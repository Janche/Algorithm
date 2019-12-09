package school.string;

/**
 * @author lirong
 * @desc
 * @date 2019/06/24 21:18
 */

public class Test {

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        String d = "ab";
        String e = "c";
        String f = d + e;
        String g = "ab" + "c";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == f);
        System.out.println(a == g);


    }
}
