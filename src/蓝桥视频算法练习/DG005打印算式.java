package 蓝桥视频算法练习;

/*
6
5 + 1 ;
4 + 2 ;4 + 1 + 1 ;
3 + 3 ;3 + 2 + 1 ;3 + 1 + 1 + 1 ;
2 + 2 + 2 ;2 + 2 + 1 + 1 ;2 + 1 + 1 + 1 + 1 ;
1 + 1 + 1 + 1 + 1 + 1 ;
 */
public class DG005打印算式 {
    public static int N = 6;
	public static void main(String[] args) {
		int[] a = new int[6];
		f(N, a, 0);
	}

	public static void f(int n, int a[], int k) {
		if (n <= 0) {
			for (int i = 0; i < k; i++) {
				if (a[0] == N) {
					System.out.println(a[0]);
					return;
				}
				if (i == k - 1) {
					System.out.print(a[i] + " ");
				} else
					System.out.print(a[i] + " + ");
			}

			System.out.print(";");

			if (a[1] == 1) {
				System.out.println();
			}
		}

		for (int i = n; i > 0; i--) {
			a[k] = i;
			if (k > 0 && i > a[k - 1])
				continue;
			f(n - i, a, k + 1);
		}

	}
}

/*
 * // 对n进行加法划分 , a 缓冲 ,k 当前的位置 public static void f(int n, int[] a, int k) {
 * 
 * if (n <= 0) { for (int i = 0; i < k; i++) { if (i == k - 1) {
 * System.out.print(a[i] + " "); } else System.out.print(a[i] + " + "); }
 * System.out.println(); } for (int i = n; i > 0; i--) { if (k > 0 && i > a[k -
 * 1]) continue; a[k] = i; f(n - i, a, k + 1); } } }
 */