package thread;

/**
 * @author lirong
 * @desc
 * @date 2019/06/24 8:46
 */

public class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 开始执行。。。");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ": 执行结束。。。");
    }
}
