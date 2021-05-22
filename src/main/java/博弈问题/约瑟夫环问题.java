package 博弈问题;

/**
 * @author lirong
 * @ClassName: 约瑟夫环问题
 * @Desc: 《幸运的基督徒》
 * 有15个基督徒和15个非基督徒在海上遇险，为了能让一部分人活下来不得不将其中15个人扔到海里面去，
 * 有个人想了个办法就是大家围成一个圈，由某个人开始从1报数，报到9的人就扔到海里面，
 * 他后面的人接着从1开始报数，报到9的人继续扔到海里面，直到扔掉15个人。
 * 由于上帝的保佑，15个基督徒都幸免于难，问这些人最开始是怎么站的，哪些位置是基督徒哪些位置是非基督徒。
 *
 */
public class 约瑟夫环问题 {

    public static void main(String[] args) {

//        getPosition(15, 9);
        int position2 = getPosition2(30, 9);
        System.out.println();
        System.out.println(position2);
    }

    /**
     * 当count < 15 算出来的结果即为本题的答案, 第15个人的数组索引为 22
     * 当count < 30 即可算出来，最后一个剩下的人，数组索引为 20
     */
    private static void getPosition(int n, int m) {
        boolean[] persons = new boolean[30];
        int count = 0, number = 0;
        while (count < n){
            for (int i = 0; i < persons.length; i++) {
                if (!persons[i]) {
                    number++;
                }
                if (number == m) {
                    count += 1;
                    number = 0;
                    persons[i] = true;
                    if(count == n) {
                        System.out.println(i);
                    }
                }

            }
        }
        for (int i=0; i<persons.length; i++){
            if (persons[i]){
                if(i == 0){
                    System.out.print("非:"+i);
                }else {
                    System.out.print(", 非:" + i);
                }
            }else {
                if(i == 0) {
                    System.out.print("基:" + i);
                }else {
                    System.out.print(", 基:" + i);
                }
            }
        }
        System.out.println();
    }
    /**
     * 公式推导博客：https://blog.csdn.net/u011500062/article/details/72855826
     *
     * 每杀掉一个人，下一个人成为头，相当于把数组向前移动M位。
     * 若已知N-1个人时，胜利者的下标位置位f ( N ? 1 , M ) f(N-1,M)f(N?1,M)，则N个人的时候
     * ，就是往后移动M为，(因为有可能数组越界，超过的部分会被接到头上，所以还要模N)，
     * 既f ( N , M ) = ( f ( N ? 1 , M ) + M ) % n f(N,M)=(f(N-1,M)+M)\%nf(N,M)=(f(N?1,M)+M)%n
     * 利用数学公式进行计算
     * f(N,M)=(f(N?1,M)+M)%N
     */
    private static int getPosition2(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
            System.out.println(p);
        }
        return p;
    }

}
