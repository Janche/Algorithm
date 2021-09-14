package leetcode.lock;

import java.util.concurrent.CountDownLatch;

/**
 * ͨ��CountDownLatch����������ʹ�̰߳�˳��ִ��
 * @author janche
 */
public class ThreadCountDownLatchDemo {
    /**
     * �����ж��߳�һ�Ƿ�ִ�У�����ʱ����Ϊ1��ִ�к��1
     */
    private static CountDownLatch c1 = new CountDownLatch(1);

    /**
     * �����ж��̶߳��Ƿ�ִ�У�����ʱ����Ϊ1��ִ�к��1
     */
    private static CountDownLatch c2 = new CountDownLatch(1);

    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            System.out.println("��Ʒ����滮������");
            //��c1����ʱ-1
            c1.countDown();
        });

        final Thread thread2 = new Thread(() -> {
            try {
                //�ȴ�c1����ʱ����ʱΪ0����������
                c1.await();
                System.out.println("������Ա������������");
                //��c2����ʱ-1
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                //�ȴ�c2����ʱ����ʱΪ0����������
                c2.await();
                System.out.println("3������Ա�����¹���");
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                //�ȴ�c2����ʱ����ʱΪ0����������
                c2.await();
                System.out.println("4������Ա�����¹���");
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                //�ȴ�c2����ʱ����ʱΪ0����������
                c2.await();
                System.out.println("5������Ա�����¹���");
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("���ϣ�");
        System.out.println("������Ա���ϰ���...");
        System.out.println("��Ʒ�������ϰ���...");
        thread1.start();
        System.out.println("������Ա���ϰ���...");
        thread2.start();
        /* ������ο��Ա�֤�����߳�ͬʱִ��*/
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
