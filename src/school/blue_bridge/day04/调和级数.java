package school.blue_bridge.day04;
/*
 1/1 + 1/2 + 1/3 + 1/4 + ... 在数学上称为调和级数。
它是发散的，也就是说，只要加上足够多的项，就可以得到任意大的数字。
但是，它发散的很慢：
前1项和达到 1.0
前4项和才超过 2.0
前83项的和才超过 5.0
那么，请你计算一下，要加多少项，才能使得和达到或超过 15.0 呢
*/
public class 调和级数 {
    public static void main(String[] args){
    	Double sum = 0.0;
    	//boolean flag = true;
    	for(int i = 1; ; ++i){
    		sum += 1.0/i;
    		if(sum >= 15.0){
    			System.out.println(i);
    			break;
    		}
    	}
    }
}