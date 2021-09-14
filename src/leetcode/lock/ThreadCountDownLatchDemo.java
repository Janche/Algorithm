package leetcode.lock;

import java.util.concurrent.CountDownLatch;

/**
 * 通过CountDownLatch（倒计数）使线程按顺序执行
 * @author janche
 */
public class ThreadCountDownLatchDemo {
    /**
     * 用于判断线程一是否执行，倒计时设置为1，执行后减1
     */
    private static CountDownLatch c1 = new CountDownLatch(1);

    /**
     * 用于判断线程二是否执行，倒计时设置为1，执行后减1
     */
    private static CountDownLatch c2 = new CountDownLatch(1);

    public static void main(String[] args) {
        final Thread thread1 = new Thread(() -> {
            System.out.println("产品经理规划新需求");
            //对c1倒计时-1
            c1.countDown();
        });

        final Thread thread2 = new Thread(() -> {
            try {
                //等待c1倒计时，计时为0则往下运行
                c1.await();
                System.out.println("开发人员开发新需求功能");
                //对c2倒计时-1
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread3 = new Thread(() -> {
            try {
                //等待c2倒计时，计时为0则往下运行
                c2.await();
                System.out.println("3测试人员测试新功能");
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread4 = new Thread(() -> {
            try {
                //等待c2倒计时，计时为0则往下运行
                c2.await();
                System.out.println("4测试人员测试新功能");
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                //等待c2倒计时，计时为0则往下运行
                c2.await();
                System.out.println("5测试人员测试新功能");
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
        /* 下面这段可以保证三个线程同时执行*/
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
