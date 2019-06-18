package 博弈问题;


/**
 * f(局面 x) --> 胜负 ？
 *  for(对我所有可能的走法){
 * 	    试走一步 --> 局面 y
 * 	    胜负 t = f(y);
 * 	  if(t==负) return 胜;
 * 	    恢复局面
 *  }
 *  return 负;
 */
public class 取球 {
	//局面：n 所剩球的数目
	public static boolean f(int n){
		
		if(n>=1 && f(n-1)==false)	return true;
		if(n>=3 && f(n-3)==false)	return true;	
		if(n>=7 && f(n-7)==false)	return true;
		if(n>=8 && f(n-8)==false)	return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(f(10));
		System.out.println(f(1));
		System.out.println(f(4));
	}
}
