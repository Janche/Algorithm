package school.blue_bridge.day01;

public class 生日蜡烛 { 
	    /** 
	     * 这题比较简单 
	     * 双重循环累计就可以了 
	     */  
	    public static void main(String[] args){  
	    	int start,end;  
	        for(start = 1 ; start < 236 ; start ++)  
	        {  
	            for( end = start ; end < 236 ; end ++ )  
	            {  
	                int sum = 0;  
	                for(int i = start; i <= end; i ++)  
	                    sum += i;  
	                if( sum == 236)  
	                {  
	                   System.out.println(start);
	                }  
	            }  
	        }  
	    }

}