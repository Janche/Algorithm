package school.blue_bridge.������Ƶ�㷨��ϰ;

public class DG004�ַ�����ת {

	public static void main(String[] args) {
		/*
		 * System.out.println(fz("abcd"));
		 * 
		 * int level = 6; for (int i = 0; i <= level; i++) {
		 * System.out.print(f(level, i) + " "); }
		 */

		System.out.println(g(3, 1));

	}

	// �ַ�����ת
	public static String fz(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		return fz(s.substring(1)) + s.charAt(0);
	}

	// �������m��ĵ�n��Ԫ��
	public static int f(int m, int n) {
		if (n == 0 || m == n)
			return 1;
		return f(m - 1, n) + f(m - 1, n - 1);
	}

	// ��m��A��n��B��ɶ���������
	public static int g(int m, int n) {
		if (m == 0 || n == 0)
			return 1;
		return g(m - 1, n) + g(m, n - 1);
	}
}
