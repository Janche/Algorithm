package ��������;

/**
 * @author lirong
 * @ClassName: Լɪ������
 * @Desc: �����˵Ļ���ͽ��
 * ��15������ͽ��15���ǻ���ͽ�ں������գ�Ϊ������һ�����˻��������ò�������15�����ӵ�������ȥ��
 * �и������˸��취���Ǵ��Χ��һ��Ȧ����ĳ���˿�ʼ��1����������9���˾��ӵ������棬
 * ��������˽��Ŵ�1��ʼ����������9���˼����ӵ������棬ֱ���ӵ�15���ˡ�
 * �����ϵ۵ı��ӣ�15������ͽ���������ѣ�����Щ���ʼ����ôվ�ģ���Щλ���ǻ���ͽ��Щλ���Ƿǻ���ͽ��
 */
public class Լɪ������ {

    public static void main(String[] args) {
        getPosition();
    }

    private static void getPosition() {
        boolean[] persons = new boolean[30];
        int count = 0, number = 0;
        while (count < 15){
            for (int i = 0; i < persons.length; i++) {
                if (!persons[i]) {
                    number++;
                }
                if (number == 9) {
                    count += 1;
                    number = 0;
                    persons[i] = true;
                }

            }
        }
        for (int i=0; i<persons.length; i++){
            if (persons[i]){
                System.out.print(", ��:"+i);
            }else {
                System.out.print(", ��:"+i);
            }
        }
    }


}
