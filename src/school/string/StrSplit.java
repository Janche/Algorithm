package school.string;

/**
 * @author lirong
 * @desc
 * 编写一个截取字符串的函数,输入一个字符串和要截取的字节长度,确保汉字不能被截取半个,比如输入(“我ABC”,4)应该输出"我AB",输入(“LAB汉”,4)应该输出"LAB汉",而不应该输出LAB和汉的一半
 *
 * 思路:在内存中,字母和符号占一个字节,而汉字占两个或三个字节.所以在截取的时候,应该一边拼接字符串,一边记录已经截取的字节长度,遇到汉字时,只要字节长度没有超出,则这个汉字就应该被全部截取
 * ---------------------
 * 作者：fly_fly_fly_pig
 * 来源：CSDN
 * 原文：https://blog.csdn.net/fly_fly_fly_pig/article/details/87883574
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * @date 2019/06/24 21:29
 */

public class StrSplit {



    public static void main(String[] args){
       splitIt("A睡D栋", 3);
    }

    public static void splitIt(String str, int num){
        String temp = null;

        //记录已经截取的字节
        StringBuffer sb = new StringBuffer();

        //记录已经截取的字节长度
        int len = 0;

        for(int i = 0; i < num && len < num ;i++){

            //获取单个字符
            temp = String.valueOf(str.charAt(i));
            //获取单个字符的字节数,累加
            len += temp.getBytes().length;
            //拼接到目标字符串上
            sb.append(temp);
        }

        System.out.println(sb.toString());

    }

}
