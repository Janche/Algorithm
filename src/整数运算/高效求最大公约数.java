package 整数运算;

public class 高效求最大公约数 {

	/**
	 * 辗转相除法求最大公约数
	 * 最小公倍数 = a * b / gcd(a,b)
	 */
	public static int gcd(int a,int b){
		if (a<0) 	a = -a;
		if (b<0)	b = -b;
		if(a==0)	return b;
		return gcd(b%a,a);
	}
	/**
	 * 求a的n次幂
	 * a = ka * p + a1;
	 * b = kb * p + b1;
	 * a%p  b%p  (a+b)%p = (a%p + b%p)%p (a*b)%p = (a%p)*(b%p)%p
	 */
	public static int f(int a,int n,int p){
		int x = 1;
		for (int i = 0; i < n; i++) {
			x = (x * a) % p;
		}
		return (int)x%p;
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(9,6));
		System.out.println(f(3,5000,17));
	}
}
