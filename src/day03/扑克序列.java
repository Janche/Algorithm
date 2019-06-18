package day03;
/*
 * 要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌
 */
public class 扑克序列{	    //这题有病，总共就两种情况，题目还给出了
    public static int count = 0;  
    public static void main(String[] args) { 
        char [] num = new char[8]; 
        f(num, 0); 
    } 
   
    public static void f(char[] num, int i) { 
        if(i == num.length){ 
            if(judge(num)){ 
                show(num); 
                count++; 
            } 
        } else {  
            for (int j = 1; j <= 4; j++) { //递归遍历赋值
                num[i] = (char)(j+'0'); 
                f(num,i+1); 
            } 
        }  
    } 
   
    public static void show(char[] num) { 
        for (int i = 0; i < num.length; i++) { 
            if(num[i] == '1') 
                System.out.print('A'); 
            else  
                System.out.print(num[i]); 
        }  
        System.out.println(); 
    } 
   
    public static boolean judge(char[] num) { 
        boolean[] bool = new boolean[5];  
        int size_A = 0, size_2 = 0, size_3 = 0, size_4 = 0; 
        for (int i = 0; i < num.length; i++) { 
            if(num[i] == '1'){
            	size_A++;  
                if(i+2 < num.length && num[i] == num[i+2] || i - 2 > 0 && num[i-2] == num[i]) 
                    bool[0] = true; 
                }  
            if(num[i] == '2'){
            	size_2++;  
                if(i+3 < num.length && num[i] == num[i+3] || i - 3 > 0 && num[i-3] == num[i]) 
                    bool[1] = true; 
                }  
            if(num[i] == '3'){
            	size_3++;  
                if(i+4 < num.length && num[i] == num[i+4] || i - 4 > 0 && num[i-4] == num[i]) 
                    bool[2] = true; 
                }  
            if(num[i] == '4'){
            	size_4++;  
                if(i+5 < num.length && num[i] == num[i+5] || i - 5 > 0 && num[i-5] == num[i]) 
                    bool[3] = true; 
                } 
            }  
        if(size_A == 2 && size_3 == 2 && size_2 == 2 && size_4 == 2){ 
            bool[4] = true; 
        }  
        return bool[0] && bool[1] && bool[2] && bool[3] && bool[4]; 
    }
}
