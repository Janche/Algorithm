package school.blue_bridge.day02;

import java.util.Scanner; 

/**
* 
该程序类似与约瑟夫环的问题
*/ 
public class 猜字母 { 
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
           //下标为TRUE时说明字母还在圈里
           arr[i] = true;
        }
        int leftCount = str1.length();
        int countNum = 0;
        int index = 0;
        while(leftCount > 1) {
           //当在圈里时
           if(arr[index] == true) {
               //下标为偶数时
               if(countNum%2 == 0) {
                   //该字母退出圈子
                   arr[index] = false;
                   //剩余字母数目减一
                   leftCount --;
               }
               countNum++;
           }
           //每报一次数，下标加一
           index ++;
           //是循环数数，当下标大于n，说明已经数了一圈，
           if(index == str1.length()) {
               //将下标设为零重新开始。
              index = 0;
              countNum = 0;
           }
        }
        for(int i=0; i<str1.length(); i++) {
           if(arr[i] == true) {
               //输出结果表示下标为1023(第1024个)的字母,即：q
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