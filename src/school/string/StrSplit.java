package school.string;

/**
 * @author lirong
 * @desc
 * ��дһ����ȡ�ַ����ĺ���,����һ���ַ�����Ҫ��ȡ���ֽڳ���,ȷ�����ֲ��ܱ���ȡ���,��������(����ABC��,4)Ӧ�����"��AB",����(��LAB����,4)Ӧ�����"LAB��",����Ӧ�����LAB�ͺ���һ��
 *
 * ˼·:���ڴ���,��ĸ�ͷ���ռһ���ֽ�,������ռ�����������ֽ�.�����ڽ�ȡ��ʱ��,Ӧ��һ��ƴ���ַ���,һ�߼�¼�Ѿ���ȡ���ֽڳ���,��������ʱ,ֻҪ�ֽڳ���û�г���,��������־�Ӧ�ñ�ȫ����ȡ
 * ---------------------
 * ���ߣ�fly_fly_fly_pig
 * ��Դ��CSDN
 * ԭ�ģ�https://blog.csdn.net/fly_fly_fly_pig/article/details/87883574
 * ��Ȩ����������Ϊ����ԭ�����£�ת���븽�ϲ������ӣ�
 * @date 2019/06/24 21:29
 */

public class StrSplit {



    public static void main(String[] args){
       splitIt("A˯D��", 3);
    }

    public static void splitIt(String str, int num){
        String temp = null;

        //��¼�Ѿ���ȡ���ֽ�
        StringBuffer sb = new StringBuffer();

        //��¼�Ѿ���ȡ���ֽڳ���
        int len = 0;

        for(int i = 0; i < num && len < num ;i++){

            //��ȡ�����ַ�
            temp = String.valueOf(str.charAt(i));
            //��ȡ�����ַ����ֽ���,�ۼ�
            len += temp.getBytes().length;
            //ƴ�ӵ�Ŀ���ַ�����
            sb.append(temp);
        }

        System.out.println(sb.toString());

    }

}
