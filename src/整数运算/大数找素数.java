package 整数运算;
/*
 * 筛选法过滤
 * 2* 3 4 5 6 7 8 9 10 11 12 13...
 * 2 3* 5 7 9 11 13...
 * 2 5* 7 11 13...
 */
public class 大数找素数 {
	public static void main(String[] args) {
		int N = 1000 * 100 * 100;
		int x = 100001;
		int[] a = new int[N];
		
		for(int i = 2; i < N/2;i++){
			if (a[i]==1) continue;
			for (int k = 2; k <= N/i; k++) {
				if (i * k < N) {
					a[i * k] = 1;
				}
			}
		}
		
		int count = 0;
		for (int i = 2; i < N; i++) {
			if (a[i]==0) {
				count++;
				if (count==x)
					System.out.println(i + " ");
			}
		}
	}
}
