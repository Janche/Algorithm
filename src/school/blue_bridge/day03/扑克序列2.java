package school.blue_bridge.day03;

/*
	������
*/
/*
 ����7�����֣�����1������2������3��...����7���������ų�һ�С�
Ҫ������1����1���������֣�����2����2���������֣��Դ����ƣ�����7֮����7���������֡����¾���һ������Ҫ������У�
17126425374635
��Ȼ�����������������Ҳ�Ƿ���Ҫ��ġ�
�����ҳ���һ�ַ���Ҫ������з�������������з�����74��ͷ�ġ�
ע�⣺ֻ��д���14λ��������������д�κζ�������ݣ�����˵��ע�͵ȡ�
74151643752
 */
public class �˿�����2 {
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
            for (int j = 1; j <= 7; j++) { //�ݹ������ֵ
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
