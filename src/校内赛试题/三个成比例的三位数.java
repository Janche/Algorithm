package У��������;

/**
 * ��1,2,3����,9���3����λ��abc,def��ghi,ÿ������ǡ��ʹ��һ��,
 * Ҫ��abc:def:ghi=1:2:3.������н�
 * 
 * ����ԭ������HashSet�Զ�ȥ�أ��ǵü����㡣
 */
import java.util.HashSet;
import java.util.Set;

public class �����ɱ�������λ�� {
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

			set.add(0); // ��Ϊ�������λ������ȡ�������Ϊ�㣬���Լ���

			if (set.size() == 10) {
				System.out.println("a:" + a + "\t b:" + b + "\t c:" + c);
			}
		}
	}

}
