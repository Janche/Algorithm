package school.blue_bridge.蓝桥视频算法练习;
/**
 * 	求n个元素的全排列
 */
public class DG003全排列 {

	public static void main(String[] args) {
		//char []data = new char[5];
		char [] data = "ABC".toCharArray();
		f(data,0);
	}

	/**
	 * k: 当前交换位置（关注点），与其后的元素交换
	 * @param a
	 * @param k
	 */
	public static void f(char[]a, int k) {

		if(k == a.length-1) {
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]);
			}
			System.out.println();
		}
		for (int i = k; i < a.length; i++) {
			//试探
			{
				char t = a[i]; a[i] = a[k]; a[k] = t;
			}
			f(a,k+1);
			//回溯
			{
				char t = a[i]; a[i] = a[k]; a[k] = t;
			}
			
		}
	}
	

}
