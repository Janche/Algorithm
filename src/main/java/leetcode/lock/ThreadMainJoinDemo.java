package leetcode.lock;

/**
 * @author janche
 * ͨ��������joinʹ�̰߳�˳��ִ��
 */
public class ThreadMainJoinDemo {

    public static void main(String[] args) throws Exception {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ʒ�������ڹ滮������...");
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("������Ա������������");
            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("������Ա�����¹���");
            }
        });

        System.out.println("����:");
        System.out.println("��Ʒ�������ϰ���");
        System.out.println("������Ա���ϰ���");
        System.out.println("������Ա���ϰ���");
        thread1.start();
        //�ڸ����̵����ӽ��̵�join()�����󣬸�������Ҫ�ȴ��ӽ����������ټ������С�
        System.out.println("������Ա�Ͳ�����Ա��Ϣ��...");
        thread1.join();
        System.out.println("��Ʒ����������滮���!");
        thread2.start();
        System.out.println("������Ա��Ϣ��...");
        thread2.join();
        thread3.start();
    }
}