package school.校内赛试题;

/**
 * @author lirong
 * @desc
 * @date 2019/06/17 22:42
 */

public class 进制转换 {

    public static void main(String[] args) {
        int k = 10;
        f(10,  49);
    }

    private static void f(int k, Integer num) {
        String arr = "";
        while (num > 0){
            int ge = num % k;
            num = num / k;
            arr += ge;
        }
        StringBuffer sb = new StringBuffer(arr);
        System.out.println(sb.reverse());



    }


}
