package thread;

/**
 * @author lirong
 * @desc
 * @date 2019/06/24 8:46
 */

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": ��ʼִ�С�����");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": ִ�н���������");
    }
}
