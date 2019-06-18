package day04;

/*
如果x的x次幂结果为10（参见【图1.png】），你能计算出x的近似值吗？
显然，这个值是介于2和3之间的一个数字。
请把x的值计算到小数后6位（四舍五入），并填写这个小数值。
注意：只填写一个小数，不要写任何多余的符号或说明。
2.506184
*/
public class 指数计算 {
	static double eps = 1e-7;
    public static void main(String[] args){
    	double l = 2,r = 3,mid;
    	while(l+eps < r){
    		mid = (l+r)/2;
    		if(Math.pow(mid,mid) < 10)
    			l = mid;
    		else
    			r = mid;
    	}
    	System.out.printf("%.6f\n",l);
    }
}