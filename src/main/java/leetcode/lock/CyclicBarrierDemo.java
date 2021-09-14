package leetcode.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *  ʹ��CyclicBarrier(�ػ�դ��)ʵ���̰߳�˳������
 * @author janche
 */
public class CyclicBarrierDemo {
    static CyclicBarrier barrier1 = new CyclicBarrier(2);
    static CyclicBarrier barrier2 = new CyclicBarrier(2);

    public static void main(String[] args) {

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("��Ʒ����滮������");
                    //�ſ�դ��1
                    barrier1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //�ſ�դ��1
                    barrier1.await();
                    System.out.println("������Ա������������");
                    //�ſ�դ��2
                    barrier2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //�ſ�դ��2
                    barrier2.await();
                    System.out.println("������Ա�����¹���");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
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
