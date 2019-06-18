package 蓝桥视频算法练习;
/*
 * 	求n个元素的全排列
 */
public class DG003全排列 {

	// k: 当前交换位置（关注点），与其后的元素交换
	public static void f(char[]a,int k){

		if(k == a.length-1)
		{
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
		}
		for (int i = k; i < a.length; i++) {
			{char t = a[i]; a[i] = a[k]; a[k] = t;}  //试探
			f(a,k+1);
			{char t = a[i]; a[i] = a[k]; a[k] = t;}  //回溯
			
		}
	}
	
	public static void main(String[] args) {
		//char []data = new char[5];
		char [] data = "ABC".toCharArray();
		f(data,0);
	}
}
