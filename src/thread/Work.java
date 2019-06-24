package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author lirong
 * @desc
 * @date 2019/06/23 23:00
 */

class Work implements Runnable {

    private CountDownLatch latch;

    public Work(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": ��ʼִ�С�����");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            System.out.println(Thread.currentThread().getName() + ": ִ�н���������");
            latch.countDown();
        }
    }
}