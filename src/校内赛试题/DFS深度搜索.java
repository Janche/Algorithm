/**
 * 找出从自然数1、2、... 、n（0<n<10）中任取r(0<r<=n)个数的所有组合
 * 特定顺序：每一个组合中的值从大到小排列，组合之间按逆字典序排列。
 */


package 校内赛试题;

import java.util.Scanner;

public class DFS深度搜索 {
	
 	static int []num = new int[100];
	private static int total;
	private static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入自然数总数：");
		total = sc.nextInt();
		System.out.println("请输入组合的长度：");
		n = sc.nextInt();
		DFS(total, n);
	}

	private static void DFS(int top,int v){
		int i;
		if(v==0) {
			for (i = n; i > 0; i--) {
				System.out.print(num[i]);
			}
			System.out.println();
			return;
		}

		for(i = top;i >= v;i--){
			num[v] = i;
			DFS(i-1,v-1);
		}
	}

}
	

