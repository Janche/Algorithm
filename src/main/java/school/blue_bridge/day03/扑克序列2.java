package school.blue_bridge.day03;

/*
	待整理
*/
/*
 今有7对数字：两个1，两个2，两个3，...两个7，把它们排成一行。
要求，两个1间有1个其它数字，两个2间有2个其它数字，以此类推，两个7之间有7个其它数字。如下就是一个符合要求的排列：
17126425374635
当然，如果把它倒过来，也是符合要求的。
请你找出另一种符合要求的排列法，并且这个排列法是以74开头的。
注意：只填写这个14位的整数，不能填写任何多余的内容，比如说明注释等。
74151643752
 */
public class 扑克序列2 {
	public static int count = 0;  
    public static void main(String[] args) { 
        char [] num = new char[14]; 
        f(num, 0);
        System.out.println(count);
    } 
   
    public static void f(char[] num, int i) { 
        if(i == num.length){ 
            if(judge(num)){ 
                show(num); 
                count++; 
            } 
        } else {  
            for (int j = 1; j <= 7; j++) { //递归遍历赋值
                num[i] = (char)(j+'0'); 
                f(num,i+1); 
            } 
        }  
    } 
   
    public static void show(char[] num) { 
        for (int i = 0; i < num.length; i++) {  
                System.out.print(num[i]); 
        }  
        System.out.println(); 
    } 
   
    public static boolean judge(char[] num) { 
        boolean[] bool = new boolean[8];  
        int size_1 = 0, size_2 = 0, size_3 = 0, size_4 = 0, size_5 = 0, size_6 = 0, size_7 = 0; 
        for (int i = 0; i < num.length; i++) { 
        	if(num[8]==7 && num[6]==4){
        		if(num[i] == '1'){
                	size_1++;  
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
                if(num[i] == '5'){
                	size_5++;  
                    if(i+6 < num.length && num[i] == num[i+6] || i - 6 > 0 && num[i-6] == num[i]) 
                        bool[4] = true; 
                    }
                if(num[i] == '6'){
                	size_6++;  
                    if(i+7 < num.length && num[i] == num[i+7] || i - 7 > 0 && num[i-7] == num[i]) 
                        bool[5] = true; 
                    }
                if(num[i] == '7'){
                	size_7++;  
                    if(i+8 < num.length && num[i] == num[i+8] || i - 8 > 0 && num[i-8] == num[i]) 
                        bool[6] = true; 
                    }
        	}
            
            }  
        if(size_1 == 2 && size_3 == 2 && size_2 == 2 && size_4 == 2 && size_5 == 2 && size_6 == 2 && size_7 == 2){ 
            bool[7] = true; 
        }  
        return bool[0] && bool[1] && bool[2] && bool[3] && bool[4] && bool[5] && bool[6] && bool[7]; 
    }
}
