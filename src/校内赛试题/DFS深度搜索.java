/**
 * �ҳ�����Ȼ��1��2��... ��n��0<n<10������ȡr(0<r<=n)�������������
 * �ض�˳��ÿһ������е�ֵ�Ӵ�С���У����֮�䰴���ֵ������С�
 */


package У��������;

import java.util.Scanner;

public class DFS������� {
	
 	static int []num = new int[100];
	private static int total;
	private static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ȼ��������");
		total = sc.nextInt();
		System.out.println("��������ϵĳ��ȣ�");
		n = sc.nextInt();
		DFS(total, n);
	}

	private static void DFS(int top,int v){
		int i;
		if(v==0) {
			for (i = n; i > 0; i--) {
				System.out.print(num[i]);
			}
			System.out.println();
			return;
		}

		for(i = top;i >= v;i--){
			num[v] = i;
			DFS(i-1,v-1);
		}
	}

}
	

