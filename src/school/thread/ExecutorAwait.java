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
                    System.out.println(Thread.currentThread().getName() + ": 开始执行。。。");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 执行结束。。。");
                }
            };
            executorService.execute(runnable);
        }

        try {
            executorService.shutdown();
            // awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔5秒循环一次
            while (!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                // 超时等待后，可以手动结束所有正常执行的线程。不执行下面的语句将循环等待，直到所有子线程结束。
                // executorService.shutdownNow();
            }
            System.out.println("所有子线程执行完毕了。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
