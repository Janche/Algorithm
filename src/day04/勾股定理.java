package day04;

/*
勾股定理，西方称为毕达哥拉斯定理，它所对应的三角形现在称为：直角三角形。
已知直角三角形的斜边是某个整数，并且要求另外两条边也必须是整数。
求满足这个条件的不同直角三角形的个数。
【数据格式】
输入一个整数 n (0<n<10000000) 表示直角三角形斜边的长度。
要求输出一个整数，表示满足条件的直角三角形个数。
例如，输入：
5
程序应该输出：
1
再例如，输入：
100
程序应该输出：
2
再例如，输入：
3
程序应该输出：
0
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
*/
import java.util.Scanner;

public class 勾股定理 {
	public static void main(String[] args) {
		while(true){
		Scanner sca = new Scanner(System.in);
		int n = sca.nextInt(),cnt = 0;
		int t = (int) Math.sqrt(n*n/2.0);  //i*i<n*n/2
		for(int i = 1; i <= t; ++i){
			int j = (int) Math.sqrt(n*n*1.0-i*i);
			if(i*i+j*j == n*n){
				System.out.println(i*i+"+"+j*j+"="+n*n);
				++cnt;
			}
		}
		System.out.println(cnt);
	}}
}
