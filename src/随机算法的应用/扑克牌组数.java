package 随机算法的应用;

import java.util.Scanner;
import java.util.Stack;

public class 扑克牌组数 {
	
	public static String random_op(){
		int n = (int)(Math.random() * 4);
		if(n==0) return "+";
		if(n==1) return "-";
		if(n==2) return "*";
		return "/";
	}
	
	public static void shuffle(String[] x){
		for (int i = 0; i < x.length; i++) {
			int j = (int)(Math.random() * x.length);
			String t = x[i];
			x[i] = x[j];
			x[j] = t;
		}
	}
	
	public static void f(String[] ss){
		//随机产生组合序列，计算==24 ok
		//6 3 4 * + -  逆波兰表达式
		for (int k = 0; k < 10000; k++) {
			String[] buf = new String[7];
			for (int i = 0; i < 4; i++) {
				buf[i] = ss[i];
			}
			for (int i = 4; i < 7; i++) {
				buf[i] = random_op();
			}
			shuffle(buf);
			
			if(ji_suan(buf)){
				show(buf);
			}
		}
	}
	public static int op(int a,int b,String oper) throws Exception{
		if(oper.equals("+")) return a + b;
		if(oper.equals("-")) return a - b;
		if(oper.equals("*")) return a * b;
		if(a%b!=0) throw new Exception ("not /");
		return a / b;
	}
	
	public static boolean ji_suan(String[] data){
		Stack stk = new Stack();
		try{
			for (int i = 0; i < data.length; i++) {
				if (data[i].equals("+")||data[i].equals("-")
						||data[i].equals("*")||data[i].equals("/")) {
					int a = Integer.parseInt((String) stk.pop());
					int b = Integer.parseInt((String) stk.pop());
					stk.push(op(a,b,data[i])+" ");
				}else{
					stk.push(data[i]);
				}
			}
		}catch(Exception e){
			return false;
		}
		if(stk.size()==1 && stk.pop().equals("24"))
			return true;
		return false;	
	}
	public static void show(String[] buf){
		System.out.println("OK");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("请输入4个整数：");
			String[] ss = sc.nextLine().split(" +");
			f(ss);
		}
	}
}
