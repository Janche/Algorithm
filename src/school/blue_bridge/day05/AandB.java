package school.blue_bridge.day05;
import java.util.Scanner;
/*
 一般情况下在线评判系统都是以文件输入结尾结束的对于C语言是EOF，
 对于JAVA来说是in.hasNextInt()!=0如果楼主以后在这些HDU或者ZOJ上面ACM的话，
 那建议你最好都用这种模式的输入，这样虽然麻烦了点但是对于所有题目所有输入格式是绝对不会有问题的！
 */
/*
 * 
 
第一种：
/**
 * 行数并没有确定，你也不要假设有什么100行，1000行之类的，也许是1亿行呢:<
 * 自行判断是否输入结束。
 
	public class AandB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a + b);
			}
		}
	}
*/
/**第二种：
*第一行一个正数n，表明下面有多少组测试。
*接下来n行，每行两个正数之间是用空格或tab隔开。
*
*/
public class AandB {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			int a = in.nextInt();
			int b = in.nextInt();
			arr[i] = a + b;
			}
		for(int i=0;i<n;i++){
			System.out.println(arr[i]);
		}
	}
}


