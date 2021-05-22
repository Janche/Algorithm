package school.blue_bridge.day05;

import java.util.Scanner;

public class LC_and_Prime {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int num = 0,count = 0;
		int arr[] = new int[n];
		for(int i=2;i<n;i++){
			boolean flag = true;
			int m = (int) Math.sqrt(i);
			for(int j=2;j<=m;j++){
				if(i%j==0){
					flag = false;
					break;
				}
			}
			if(flag){
				arr[num] = i;
				num++;
			}			
		}
//		for(int i=0;i<num;i++){
//			System.out.print(arr[i]+" ");
//		}
		
		int p1,p2,p3;
		for(int i=0;i<num;i++){
			p1 = arr[i];
			for(int j=i;j<num;j++){
				p2 = arr[j];
				for(int k=j;k<num;k++){
					p3 = arr[k];
					if((p1+p2+p3)==n){
						count++;
						System.out.println(p1+"-"+p2+"-"+p3);
					}
				}	
			}
		}
		System.out.println(count);
		
	}
}
