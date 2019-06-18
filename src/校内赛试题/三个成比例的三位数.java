package 校内赛试题;

/**
 * 用1,2,3……,9组成3个三位数abc,def和ghi,每个数字恰好使用一次,
 * 要求abc:def:ghi=1:2:3.输出所有解
 * 
 * 解题原理：利用HashSet自动去重，记得加上零。
 */
import java.util.HashSet;
import java.util.Set;

public class 三个成比例的三位数 {
	public static void main(String[] args) {
		for (int a = 100; a < 333; a++) {

			int b = 2 * a;
			int c = 3 * a;

			Set set = new HashSet();

			set.add(a % 10);
			set.add(a / 10 % 10);
			set.add(a / 100);

			set.add(b % 10);
			set.add(b / 10 % 10);
			set.add(b / 100);

			set.add(c % 10);
			set.add(c / 10 % 10);
			set.add(c / 100);

			set.add(0); // 因为上面的三位数分离取整后可能为零，所以加上

			if (set.size() == 10) {
				System.out.println("a:" + a + "\t b:" + b + "\t c:" + c);
			}
		}
	}

}
