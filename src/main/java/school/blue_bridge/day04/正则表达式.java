package school.blue_bridge.day04;

/**
 *  java���ṩ�˶�������ʽ��֧�֡�
 * �е�ʱ��ǡ����ʹ�����򣬿��������ǵĹ����°빦����
 * ���´�����������һ����������ʽ�����������Ŀ������д���߲���ȱ�ٵĴ���
 * ע�⣺ֻ��дȱ�ٴ��룬��Ҫд�κζ������ݣ����磬���е�˫���š�
 */
public class ������ʽ {
	public static int f(String s) {
		return s.split("\\p{Punct}").length;
	}
	
	public static void main(String[] args) {
        //7
		System.out.println(f("12+35*5-2*18/9-3"));
        //6
		System.out.println(f("354*12+3-14/7*6"));
	}
}