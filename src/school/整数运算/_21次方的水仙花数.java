package school.整数运算;
/**
 * 类似与水仙花数，不过是21次方
 */
import java.math.BigInteger;

public class _21次方的水仙花数 {
	private static BigInteger[] base = new BigInteger[10]; //每个数字21次方
	
	private static BigInteger calcu_21(int n){
		BigInteger a = BigInteger.ONE;
		for (int i = 0; i < 21; i++) {
			a = a.multiply(BigInteger.valueOf(n));
		}
		return a;
	}
	
	private static void test(int[] a) {
		BigInteger bn = BigInteger.ZERO;
		for (int i = 0; i < a.length; i++) {
			bn = bn.add(base[i].multiply(BigInteger.valueOf(a[i])));
		}
		String s= bn.toString();
		if (s.length()!=21) 
			return;
		int[]b = new int[10];
		for (int i = 0; i < s.length(); i++) {
			b[s.charAt(i)-'0']++;
		}
		
		for (int i = 0; i < 10; i++) {
			if (a[i]!=b[i]) 
				return;
		}
		System.out.println(bn);
	}
	//处理第k个，还有sum个名额
	private static void f(int[]a,int k,int sum){
		if (sum==0) {
			test(a);
			return;
		}
		if(k==a.length-1){
			a[k] = sum;
			test(a); //或者等价于f(a,k+1,0);
			return;
		}
		
		for (int i = 0; i <= sum; i++) {
			a[k] = i;
			f(a,k+1,sum-i);
			a[k] = 0;
		}
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < base.length; i++) 
			base[i] = calcu_21(i);
		
			int[] a = new int[10];//每个数字出现几次
			f(a,0,21);
		
	}
}
