package school.blue_bridge.day04;
/*
 1/1 + 1/2 + 1/3 + 1/4 + ... ����ѧ�ϳ�Ϊ���ͼ�����
���Ƿ�ɢ�ģ�Ҳ����˵��ֻҪ�����㹻�����Ϳ��Եõ����������֡�
���ǣ�����ɢ�ĺ�����
ǰ1��ʹﵽ 1.0
ǰ4��Ͳų��� 2.0
ǰ83��ĺͲų��� 5.0
��ô���������һ�£�Ҫ�Ӷ��������ʹ�úʹﵽ�򳬹� 15.0 ��
*/
public class ���ͼ��� {
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