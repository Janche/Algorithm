package leetcode.lock;

/**
 * @author janche
 * �������̰߳�˳��ִ��
 */
public class ThreadJoinDemo {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("��Ʒ����滮������");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread1.join();
                    System.out.println("������Ա������������");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread2.join();
                    System.out.println("������Ա�����¹���");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        thread3.start();
        System.out.println("��Ʒ�������ϰ���...");
        thread1.start();
        System.out.println("������Ա���ϰ���...");
        thread2.start();
    }
}
