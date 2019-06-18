package day05;
import java.util.Scanner;

/*
 * ����һ����Χ[l,r]����[l, r]�еľ���������������������;�����Զ����������������
 * ������ڣ���������ʽ��������������������Զ����������������ж���������С�ģ���
 * ��������ڣ����һ�У�There are no adjacent primes.
 */
public class GZS�������� {
	public static void main(String[] args) {
			//long m1 = System.currentTimeMillis();
			long m,num=0;
			long i = 0;
			Scanner sc = new Scanner(System.in);
			long l = sc.nextInt();
			long r = sc.nextInt();
			long[] arr = new long[(int)(5*1e6)]; 
			for(i=l;i<=r;i++)
			{
				boolean flag = true;
				m = (long)Math.sqrt(i);    //m��Ϊi/2,i-1,����i.
				for(long j=2;j<=m;j++){
					if(i%j==0)
					{
						flag = false;
					    break;
					}
				}	
				if(flag)
				{
					arr[(int) num] = i;
					num++;	
				}
			}
			/*for( i=0;i<num;i++){
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			System.out.println("����Ϊ��"+num);
			*/
			long max = arr[1]-arr[0];
			long min = arr[1]-arr[0];
			long temp,a = 0,b = 0;
			for( i=0;i<num-1;i++){
				temp = arr[(int) (i+1)]-arr[(int) i];
				if(temp > max){
					max = temp;
					a = i;	
				}
				if(temp < min){
					min = temp;
					b = i;
				}
			}
			if(num>=2){
				System.out.println(arr[(int) b]+","+arr[(int) b+1]+" are closest, "+arr[(int) a]+","+arr[(int) a+1]+" are most distant.");
				//System.out.println("min:"+arr[b]+"--"+arr[b+1]);
			}
			else{
				System.out.println("There are no adjacent primes.");
			}
			//long m2 = System.currentTimeMillis();
			//System.out.println(m2-m1);
			
	}
	
}




