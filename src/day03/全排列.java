package day03;

import org.junit.Test;

public class ȫ���� {  
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
        	/*���else��������� :   
        	1��������һ��λ�õ��ַ��������һ��λ�õ�ȫ�����ַ���ȫ����ӡ��Ͱѵ�һ���ַ��͵ڶ���������
        	2���ݹ��ӡÿ�ε�һ���ַ�����ȫ�����ַ�����
        	3��ÿ�εݹ��ʱ�򶼻ᴫ��һ���ַ������飬������д�����ǿ�������ַ������鲻�䣬
        	       ��˼���� ʲô���Ӵ��ݳ�ȥ����ʲô���Ӵ��ݻ�����һ�㲻�ܱ仯����Ϊ������д��벻�����ڸı� �ַ��������
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
        	//����жϺܹؼ���ÿ�εݹ鵽����ʱ�򣬾���STARTÿ�ζ�����END��ʱ�򣬾���Ҫ��ӡ���� Ӧ��ȫ�����ַ�����ʱ��  
        	if(start==end){//����ж����ڵݹ鵽����ʱ�������Ӧ���ַ���  
                for(int i=0;i<=end;i++){  
                    System.out.print(buf[i]);  
                }  
                System.out.println();     
            }  
            else{/*���else��������� :   
            	1��������һ��λ�õ��ַ��������һ��λ�õ�ȫ�����ַ���ȫ����ӡ��Ͱѵ�һ���ַ��͵ڶ���������
            	2���ݹ��ӡÿ�ε�һ���ַ�����ȫ�����ַ�����
            	3��ÿ�εݹ��ʱ�򶼻ᴫ��һ���ַ������飬������д�����ǿ�������ַ������鲻�䣬
            	       ��˼���� ʲô���Ӵ��ݳ�ȥ����ʲô���Ӵ��ݻ�����һ�㲻�ܱ仯����Ϊ������д��벻�����ڸı� �ַ��������
			     */
                for(int i=start;i<=end;i++){  
                    /*char temp=buf[start];//�����д������ڿ��Ƶ�һ��λ�õ��ַ�����������1  
                    buf[start]=buf[i]; //����,��һ��ʱ�ĵ�һ���ַ���ȫ����������, 
                    					//Ȼ��ѵ�һ���͵ڶ����ַ����н���,������,������                 
                    buf[i]=temp;*/  		//�ձ���������һ��λ���ַ��� ȫ�����ַ���   
                	swap1(buf, start, i);
                	
                    perm(buf,start+1,end);//ͨ��start����Ҫ��������ַ�������Ӧ����2
                     
                    swap1(buf, i, start);
                    /*temp=buf[start];	//�������ǰѱ任����ַ���˳����л�ԭ,�ܹ��任�ַ���˳��ģ���Ӧ����3                      					//������ڵݹ麯��perm()�������У����ڽ����ַ���˳����                 
                    buf[start]=buf[i];  //�����������ȫ�����ַ���
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
