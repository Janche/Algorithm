package ��������;

/**
 * @author lirong
 * @ClassName: Լɪ������
 * @Desc: �����˵Ļ���ͽ��
 * ��15������ͽ��15���ǻ���ͽ�ں������գ�Ϊ������һ�����˻��������ò�������15�����ӵ�������ȥ��
 * �и������˸��취���Ǵ��Χ��һ��Ȧ����ĳ���˿�ʼ��1����������9���˾��ӵ������棬
 * ��������˽��Ŵ�1��ʼ����������9���˼����ӵ������棬ֱ���ӵ�15���ˡ�
 * �����ϵ۵ı��ӣ�15������ͽ���������ѣ�����Щ���ʼ����ôվ�ģ���Щλ���ǻ���ͽ��Щλ���Ƿǻ���ͽ��
 *
 */
public class Լɪ������ {

    public static void main(String[] args) {

//        getPosition(15, 9);
        int position2 = getPosition2(30, 9);
        System.out.println();
        System.out.println(position2);
    }

    /**
     * ��count < 15 ������Ľ����Ϊ����Ĵ�, ��15���˵���������Ϊ 22
     * ��count < 30 ��������������һ��ʣ�µ��ˣ���������Ϊ 20
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
                    System.out.print("��:"+i);
                }else {
                    System.out.print(", ��:" + i);
                }
            }else {
                if(i == 0) {
                    System.out.print("��:" + i);
                }else {
                    System.out.print(", ��:" + i);
                }
            }
        }
        System.out.println();
    }
    /**
     * ��ʽ�Ƶ����ͣ�https://blog.csdn.net/u011500062/article/details/72855826
     *
     * ÿɱ��һ���ˣ���һ���˳�Ϊͷ���൱�ڰ�������ǰ�ƶ�Mλ��
     * ����֪N-1����ʱ��ʤ���ߵ��±�λ��λf ( N ? 1 , M ) f(N-1,M)f(N?1,M)����N���˵�ʱ��
     * �����������ƶ�MΪ��(��Ϊ�п�������Խ�磬�����Ĳ��ֻᱻ�ӵ�ͷ�ϣ����Ի�ҪģN)��
     * ��f ( N , M ) = ( f ( N ? 1 , M ) + M ) % n f(N,M)=(f(N-1,M)+M)\%nf(N,M)=(f(N?1,M)+M)%n
     * ������ѧ��ʽ���м���
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
