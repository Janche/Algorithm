package ������Ƶ�㷨��ϰ;
/*
 * 	��n��Ԫ�ص�ȫ����
 */
public class DG003ȫ���� {

	// k: ��ǰ����λ�ã���ע�㣩��������Ԫ�ؽ���
	public static void f(char[]a,int k){

		if(k == a.length-1)
		{
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
		}
		for (int i = k; i < a.length; i++) {
			{char t = a[i]; a[i] = a[k]; a[k] = t;}  //��̽
			f(a,k+1);
			{char t = a[i]; a[i] = a[k]; a[k] = t;}  //����
			
		}
	}
	
	public static void main(String[] args) {
		//char []data = new char[5];
		char [] data = "ABC".toCharArray();
		f(data,0);
	}
}
