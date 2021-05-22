package school.blue_bridge.day05;

import java.util.Scanner;

public class GZS����ů {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];
		//System.out.println(1e6);
		for(int i=0;i<n;i++){
			int a = in.nextInt();
			if(a<=1e6)
			 arr[i] = a;
		}
		int k = in.nextInt();
		quicksort(arr,0,arr.length-1);
		//Arrays.sort(arr);
		/*for(int i=0;i<n;i++){
			System.out.println(arr[i]);
		}*/
		System.out.println(arr[k-1]);
	}
	
	private static void quicksort(int a[], int left, int right)
	{
	    if(left >= right)/*�������������ڻ��ߵ����ұߵ������ʹ����Ѿ��������һ������*/
	    {
	        return ;
	    }
	    int i = left;
	    int j = right;
	    int key = a[left];
	     
	    while(i < j)                               /*�����ڵ�����Ѱ��һ��*/
	    {
	        while(i < j && key <= a[j])
	        /*��Ѱ�ҽ������������ǣ�1���ҵ�һ��С�ڻ��ߴ���key���������ڻ�С��ȡ����������
	        ���ǽ���2��û�з�������1�ģ�����i��j�Ĵ�Сû�з�ת*/ 
	        {
	            j--;/*��ǰѰ��*/
	        }
	         
	        a[i] = a[j];
	        /*�ҵ�һ������������Ͱ�������ǰ��ı����ߵ�i��ֵ�������һ��ѭ����key��
	        a[left]����ô���Ǹ�key��*/
	         
	        while(i < j && key >= a[i])
	        /*����i�ڵ�������ǰѰ�ң�ͬ�ϣ�����ע����key�Ĵ�С��ϵֹͣѭ���������෴��
	        ��Ϊ����˼���ǰ����������ӣ������������ߵ�����С��key�Ĺ�ϵ�෴*/
	        {
	            i++;
	        }
	         
	        a[j] = a[i];
	    }
	     
	    a[i] = key;       /*���ڵ���������һ���Ժ�Ͱ��м���key�ع�*/
	    quicksort(a, left, i - 1);/*�����ͬ���ķ�ʽ�Էֳ�������ߵ�С�����ͬ�ϵ�����*/
	    quicksort(a, i + 1, right);/*��ͬ���ķ�ʽ�Էֳ������ұߵ�С�����ͬ�ϵ�����*/
		}
}
