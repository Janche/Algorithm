package 校内赛试题;

import java.util.Scanner;
import java.util.Stack;

public class 字符串反转 { 
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		
		 StringBuffer sb = new StringBuffer();
		   String[] a = s1.split(" ");
		   for (int i = 0; i < a.length; i++) {
			  sb.append(reverse4(a[i].toString()));
			  sb.append(" ");
		   }
//		ss = reverse2(s1);
		
//		ss = reverse4(s1);
		
		System.out.println(sb);
	}
	 
	 public static String reverse1(String s) {  
		 
		 StringBuffer sb = new StringBuffer();
		   String[] a = s.split("");
		   for (int i = 0; i < a.length; i++) {
			   sb.append(reverse2(a[i].toString().trim()));
		   }
		   
	 /* int length = s.length();  
	  if (length <= 1)  
	   return s;  
	  String left = s.substring(0, length / 2);  
	  String right = s.substring(length / 2, length);*/  
	  return sb.toString();  
	 }  
	    
	 public final static String reverse2(String s) {  
	  int length = s.length();  
	  String reverse = "";  
	  for (int i = 0; i < length; i++)  
	   reverse = s.charAt(i) + reverse;  
	  return reverse;  
	 }  
	    
	 public static String reverse3(String s) {  
	  char[] array = s.toCharArray();  
	  String reverse = "";  
	  for (int i = array.length - 1; i >= 0; i--)  
	   reverse += array[i];  
	    
	  return reverse;  
	 }  
	    
	 public static String reverse4(String s) {  
	  return new StringBuffer(s).reverse().toString();  
	 }  
	    
	 public static String reverse5(String orig) {  
	  char[] s = orig.toCharArray();  
	  int n = s.length - 1;  
	  int halfLength = n / 2;  
	  for (int i = 0; i <= halfLength; i++) {  
	   char temp = s[i];  
	   s[i] = s[n - i];  
	   s[n - i] = temp;  
	  }  
	  return new String(s);  
	 }  
	    
	 public static String reverse6(String s) {  
	    
	  char[] str = s.toCharArray();  
	    
	  int begin = 0;  
	  int end = s.length() - 1;  
	    
	  while (begin < end) {  
	   str[begin] = (char) (str[begin] ^ str[end]);  
	   str[end] = (char) (str[begin] ^ str[end]);  
	   str[begin] = (char) (str[end] ^ str[begin]);  
	   begin++;  
	   end--;  
	  }  
	    
	  return new String(str);  
	 }  
	    
	 public static String reverse7(String s) {  
	  char[] str = s.toCharArray();  
	  Stack<Character> stack = new Stack<Character>();  
	  for (int i = 0; i < str.length; i++)  
	   stack.push(str[i]);  
	    
	  String reversed = "";  
	  for (int i = 0; i < str.length; i++)  
	   reversed += stack.pop();  
	    
	  return reversed;  
	 }  
	    
	} 
