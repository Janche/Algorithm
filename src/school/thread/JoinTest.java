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
                        System.out.println(Thread.currentThread().getName() + ": 33��ʼִ�С�����");
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ": 33ִ�н���������");
                    }
                });
            }
            thread.start();
            list.add(thread);
        }
        try {
            for(Thread thread : list) {
                System.out.println(thread.getName()+"=============");
                // ���Ա�������һ��Thread.join��ɺ󣬲Ż����ѭ����һ��join
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("�������߳�ִ������ˡ�����");
    }

}
