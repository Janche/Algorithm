package leetcode.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> System.out.println("��Ʒ����滮������"));

        Thread thread2 = new Thread(() -> System.out.println("������Ա������������"));

        Thread thread3 = new Thread(() -> System.out.println("������Ա�����¹���"));

        System.out.println("���ϣ�");
        System.out.println("��Ʒ�������ϰ���");
        System.out.println("������Ա���ϰ���");
        System.out.println("������Ա���ϰ���");
        System.out.println("�쵼�Ը�:");
        System.out.println("���ȣ���Ʒ����滮������...");
        executorService.submit(thread1);
        System.out.println("Ȼ�󣬿�����Ա������������...");
        executorService.submit(thread2);
        System.out.println("��󣬲�����Ա�����¹���...");
        executorService.submit(thread3);
        executorService.shutdown();
    }
}
