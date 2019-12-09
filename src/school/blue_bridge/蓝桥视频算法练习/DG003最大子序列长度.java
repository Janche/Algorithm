package school.blue_bridge.蓝桥视频算法练习;

public class DG003最大子序列长度 {

	public static int f(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0)
			return 0;
		if (s1.charAt(0) == s2.charAt(0))
			return f(s1.substring(1), s2.substring(1)) + 1;
		else
			return Math.max(f(s1, s2.substring(1)), f(s1.substring(1), s2));
	}

	public static void main(String[] args) {

		int k = f("eabdcds", "abcdeg");
		System.out.println(k);

//		String s = "123456789";
//		System.out.println(s.charAt(s.length()-1));
//		System.out.println(s.substring(0) + "--");
//		System.out.println(s.substring(1) + "--");

	}

}
