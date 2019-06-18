package day04;

/*
���x��x���ݽ��Ϊ10���μ���ͼ1.png���������ܼ����x�Ľ���ֵ��
��Ȼ�����ֵ�ǽ���2��3֮���һ�����֡�
���x��ֵ���㵽С����6λ���������룩������д���С��ֵ��
ע�⣺ֻ��дһ��С������Ҫд�κζ���ķ��Ż�˵����
2.506184
*/
public class ָ������ {
	static double eps = 1e-7;
    public static void main(String[] args){
    	double l = 2,r = 3,mid;
    	while(l+eps < r){
    		mid = (l+r)/2;
    		if(Math.pow(mid,mid) < 10)
    			l = mid;
    		else
    			r = mid;
    	}
    	System.out.printf("%.6f\n",l);
    }
}