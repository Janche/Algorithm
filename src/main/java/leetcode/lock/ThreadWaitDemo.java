package main.java.leetcode.lock;

public class ThreadWaitDemo {
    private static Object myLock1 = new Object();
    private static Object myLock2 = new Object();

    /**
     * ΪʲôҪ����������ʶ״̬?
     * ���û��״̬��ʶ����t1�Ѿ���������t2�����У�t2�ڵȴ�t1���ѵ���t2��Զ���ڵȴ�״̬
     */
    private static Boolean t1Run = false;
    private static Boolean t2Run = false;
    public static void main(String[] args) {

        final Thread thread1 = new Thread(() -> {
            synchronized (myLock1){
                System.out.println("��Ʒ����滮������...");
                t1Run = true;
                myLock1.notify();
            }
        });

        final Thread thread2 = new Thread(() -> {
            synchronized (myLock1){
                try {
                    if(!t1Run){
                        System.out.println("������Ա����Ϣ��...");
                        myLock1.wait();
                    }
                    synchronized (myLock2){
                        System.out.println("������Ա������������");
                        myLock2.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread thread3 = new Thread(() -> {
            synchronized (myLock2){
                try {
                    if(!t2Run){
                        System.out.println("������Ա����Ϣ��...");
                        myLock2.wait();
                    }
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
