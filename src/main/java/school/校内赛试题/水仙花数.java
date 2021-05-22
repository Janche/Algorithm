package school.校内赛试题;


public class 水仙花数 {

	public static void main(String[] args) {
		int count = 0;

		for (int i = 100; i < 1000; i++) {
	
			int a = i/100;
			int b = i/10%10;
			int c = i%10;
			if(i == a*a*a + b*b*b + c*c*c){
				count++;
			}
		}
		System.out.println(count);
		
	}
}
