package school.整数运算;

public class 两数组装成的最小任意数 {
	static final int N = 1000 * 100;
	static int juge(int[]da,int a){
		int n = 0;
		for (int i = 0; i < da.length; i++) {
			if (da[i]==1) {
				n++;
				if (n>=a) 
					return i-a;
			} else 
				n = 0;
		}
		return -1;
	}
	
	static void f(int a,int b){
		int[]da = new int[N];
		for (int i = 0; i <= N/a; i++) {
			for (int j = 0; j <= (N-i*a)/b; j++) {
				if (i*a + j*b<N) {
					da[i*a + j*b] = 1;
				}
			}
		}
		System.out.println(juge(da,a));
	}

	public static void main(String[] args) {
		f(2,3);
		f(3,5);
		f(3,4);
		f(4,7);
	}
}
