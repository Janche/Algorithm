package school.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lirong
 * @desc
 * @date 2019/06/24 10:02
 */

public class ExecutorAwait {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 4; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ": ��ʼִ�С�����");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": ִ�н���������");
                }
            };
            executorService.execute(runnable);
        }

        try {
            executorService.shutdown();
            // awaitTermination����false����ʱ�����ѭ��������true���̳߳��е��߳�ִ��������߳�����ѭ������ִ�У�ÿ��5��ѭ��һ��
            while (!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                // ��ʱ�ȴ��󣬿����ֶ�������������ִ�е��̡߳���ִ���������佫ѭ���ȴ���ֱ���������߳̽�����
                // executorService.shutdownNow();
            }
            System.out.println("�������߳�ִ������ˡ�����");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
