package day01;
import java.util.Scanner;
public class 梦境与现实 {
	public static void main(String[] args) {
		int i;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b[] = {0};
		for(i=0;i<n;i++){
			
			b[i] = new Scanner(System.in).nextInt();
			//System.out.println(b[i]);
		}
		
		for(int j=0;j<n;j++){
			System.out.println(b[j]);
		}
		
		
	}
}
