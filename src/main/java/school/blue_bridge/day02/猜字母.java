package school.blue_bridge.day02;

import java.util.Scanner; 

/**
* 
�ó���������Լɪ�򻷵�����
*/ 
public class ����ĸ { 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = "abcdefghijklmnopqrs";
        String str1 = "";
        for(int i = 0;i < 106;i++){
           str1 = str1 + str;
        }
        System.out.println(str1.length());
        boolean[] arr = new boolean[str1.length()];
        for(int i=0; i<arr.length; i++) {
           //�±�ΪTRUEʱ˵����ĸ����Ȧ��
           arr[i] = true;
        }
        int leftCount = str1.length();
        int countNum = 0;
        int index = 0;
        while(leftCount > 1) {
           //����Ȧ��ʱ
           if(arr[index] == true) {
               //�±�Ϊż��ʱ
               if(countNum%2 == 0) {
                   //����ĸ�˳�Ȧ��
                   arr[index] = false;
                   //ʣ����ĸ��Ŀ��һ
                   leftCount --;
               }
               countNum++;
           }
           //ÿ��һ�������±��һ
           index ++;
           //��ѭ�����������±����n��˵���Ѿ�����һȦ��
           if(index == str1.length()) {
               //���±���Ϊ�����¿�ʼ��
              index = 0;
              countNum = 0;
           }
        }
        for(int i=0; i<str1.length(); i++) {
           if(arr[i] == true) {
               //��������ʾ�±�Ϊ1023(��1024��)����ĸ,����q
              System.out.println(i);
              System.out.println(str1.toCharArray()[i]);
           }
        }
    }
/*
	@Test
	public void test(){
		Scanner s = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		   String str = "abcdefghijklmnopqrs";
		   for(int i = 0;i < 106;i++){ 
		       sb.append(str); 
		       } 
		   System.out.println(sb.length());
		    
		   int countNum = 0;
		   int index = 0;
		   int leftLength = sb.length();
		   while(leftLength>1900){
			   if(index%2 == 0){
				   sb.deleteCharAt(index);
				   sb.insert(index, 1);
			   }
			   index++;
//			   if(index == sb.length()){
//				   index = 0;
//				   
//			   }
		   }
		   for(int i=0; i<sb.length(); i++) { 
			   System.out.print(sb);
		   }
		   
		
	}*/

}