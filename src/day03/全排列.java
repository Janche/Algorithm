package day03;

import org.junit.Test;

public class 全排列 {  
    public static int total = 0;
    public static int count = 0;
    public static void swap(String[] str, int i, int j)  
    {  
        String temp = new String();  
        temp = str[i];  
        str[i] = str[j];  
        str[j] = temp;  
    }  
    public static void arrange (String[] str, int st, int len)  
    {  
        if (st == len - 1)  
        {  
            for (int i = 0; i < len; i ++)  
            {  
                System.out.print(str[i]+ "  ");  
            }  
            System.out.println();  
            total++;  
        }  
        else  
        {  
        	/*这个else块的作用有 :   
        	1：交换第一个位置的字符，比如第一个位置的全排列字符串全部打印后就把第一个字符和第二个交换；
        	2：递归打印每次第一个字符串的全排列字符串；
        	3：每次递归的时候都会传递一个字符串数组，最后三行代码就是控制这个字符串数组不变，
        	       意思就是 什么样子传递出去，就什么样子传递回来，一点不能变化，因为最后三行代码不是用于改变 字符串数组的
		     */
            for (int i = st; i < len; i ++)  
            {  
                swap(str, st, i);  
                arrange(str, st + 1, len);  
                swap(str, st, i);  
            }  
        }  
          
    }  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
         String str[] = {"a","b","c","d"};  
         arrange(str, 0, str.length);  
         System.out.println(total);  
    }
    
    @Test
    public void AllSort(){  
          
            char buf[]={'a','b','c'};      
            perm(buf,0,buf.length-1);  
        } 
	    public static void swap1(char[] buf, int i, int j)  
	    {  
	        char temp;  
	        temp = buf[i];  
	        buf[i] = buf[j];  
	        buf[j] = temp;  
	    }  
        public void perm(char[] buf,int start,int end){  
        	//这个判断很关键，每次递归到最后的时候，就是START每次都等于END的时候，就是要打印出相 应的全排列字符串的时候，  
        	if(start==end){//这个判断用于递归到最后的时候输出相应的字符串  
                for(int i=0;i<=end;i++){  
                    System.out.print(buf[i]);  
                }  
                System.out.println();     
            }  
            else{/*这个else块的作用有 :   
            	1：交换第一个位置的字符，比如第一个位置的全排列字符串全部打印后就把第一个字符和第二个交换；
            	2：递归打印每次第一个字符串的全排列字符串；
            	3：每次递归的时候都会传递一个字符串数组，最后三行代码就是控制这个字符串数组不变，
            	       意思就是 什么样子传递出去，就什么样子传递回来，一点不能变化，因为最后三行代码不是用于改变 字符串数组的
			     */
                for(int i=start;i<=end;i++){  
                    /*char temp=buf[start];//这三行代码用于控制第一个位置的字符，就是作用1  
                    buf[start]=buf[i]; //比如,第一次时的第一个字符的全排列输出完后, 
                    					//然后把第一个和第二个字符进行交换,交换后,再排列                 
                    buf[i]=temp;*/  		//刚被交换到第一个位置字符的 全排列字符串   
                	swap1(buf, start, i);
                	
                    perm(buf,start+1,end);//通过start控制要被输出的字符串，对应作用2
                     
                    swap1(buf, i, start);
                    /*temp=buf[start];	//这三行是把变换后的字符串顺序进行还原,能够变换字符串顺序的，对应作用3                      					//代码就在递归函数perm()上面三行，用于交换字符串顺序来                 
                    buf[start]=buf[i];  //交换出所需的全排列字符串
                    buf[i]=temp; */ 
                }  
            }  
        }  
        
        @Test
        public void Test2(){
        	char buf[] = {'a','b','c','d'};
        	quanpailie(buf,0,buf.length-1);	
        	System.out.println(count);
        }
        
        private static void swap2(char buf[],int i,int j){
        	char temp;
        	temp = buf[i];
        	buf[i] = buf[j];
        	buf[j] = temp;
        }
		private static void quanpailie(char buf[], int start, int end) {
			if(start == end){
				for(int i = 0;i <= end;i++){
					System.out.print(buf[i]);
				}
				System.out.println();
				count++;
			}
			else{
				for(int j = start;j <= end;j++){
					swap2(buf,start,j);
					quanpailie(buf,start+1,end);
					swap2(buf,j,start);
				}
				
			}
			
		}
}
