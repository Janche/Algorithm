package 蓝桥视频算法练习;

/*在n个球中，任意取出m个（不放回），
 求有多少种不同的取法*/

public class DG002 {
	private static int f(int n,int m) {
		if(n < m)
			return 0;
		if(n == m)
			return 1;
		if(m == 0)
			return 1;
				
		return f(n-1,m-1) + f(n-1,m);
	}

	public static void main(String[] args) {
		int k = f(10,3);
		System.out.println(k);
	}

}
