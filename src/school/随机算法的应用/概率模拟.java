package school.����㷨��Ӧ��;
/*
 * 30�˵İ༶�����������ظ��ĸ����ж��
 */
public class ����ģ�� {
	public static void main(String[] args) {
		final int N = 1000 * 100;
		int n = 0;
		
		for (int i = 0; i <N; i++) {
			int[] x = new int[365];
			for(int j=0;j<30;j++){
				int p = (int)(Math.random()*365);
				if(x[p]==1){
					n++;
					break;
				}else
					x[p] = 1;
			}
		}
		double r = (double)n/N;
		System.out.println(r);
	}
}
