package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lirong
 * @desc
 * @date 2019/06/22 23:46
 */
public class CountDownLautchTest {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(4);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 4; i++) {
            executorService.execute(new Work(latch));
        }
        try {
            latch.await();
            System.out.println("所有子线程执行完毕了。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


