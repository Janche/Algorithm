package school.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lirong
 * @desc
 * @date 2019/06/24 9:42
 */

public class JoinTest {

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for(int i = 0; i < 4; i++) {

            Thread thread = new Thread(new MyThread());
            if (i == 0){
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + ": 33开始执行。。。");
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ": 33执行结束。。。");
                    }
                });
            }
            thread.start();
            list.add(thread);
        }
        try {
            for(Thread thread : list) {
                System.out.println(thread.getName()+"=============");
                // 测试表明，第一个Thread.join完成后，才会继续循环下一个join
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有子线程执行完毕了。。。");
    }

}
