package school.blue_bridge.day05;
import java.util.Scanner;
/*
 һ���������������ϵͳ�������ļ������β�����Ķ���C������EOF��
 ����JAVA��˵��in.hasNextInt()!=0���¥���Ժ�����ЩHDU����ZOJ����ACM�Ļ���
 �ǽ�������ö�������ģʽ�����룬������Ȼ�鷳�˵㵫�Ƕ���������Ŀ���������ʽ�Ǿ��Բ���������ģ�
 */
/*
 * 
 
��һ�֣�
/**
 * ������û��ȷ������Ҳ��Ҫ������ʲô100�У�1000��֮��ģ�Ҳ����1������:<
 * �����ж��Ƿ����������
 
	public class AandB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a + b);
			}
		}
	}
*/
/**�ڶ��֣�
*��һ��һ������n�����������ж�������ԡ�
*������n�У�ÿ����������֮�����ÿո��tab������
*
*/
public class AandB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			arr[i] = a + b;
			}
		for(int i=0;i<n;i++){
			System.out.println(arr[i]);
		}
	}
}


