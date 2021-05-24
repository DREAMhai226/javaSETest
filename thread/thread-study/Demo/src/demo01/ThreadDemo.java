package demo01;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author HL Zhou
 * @Date 2021/5/15 10:43
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //创建线程池对象
        ExecutorService service = Executors.newFixedThreadPool(2);
        //创建Runnable实例对象
        MyRunnable runnable = new MyRunnable();

        //自己创建线程对象的方式
        // Thread t = new Thread(r);
        // r.start(); ---> 调用MyRunnable中的run()

        //从线程池中获取线程对象，然后调用MyRunnable中的Run()
        service.submit(runnable);
        // 再获取个线程对象，调用MyRunnable中的run()
        service.submit(runnable);
        service.submit(runnable);
        // 注意：submit方法调用结束后，程序并不终止，是因为线程池控制了线程的关闭。
        // 将使用完的线程又归还到了线程池中
        // 关闭线程池
        service.shutdown();
    }
}
class MyRunnable implements Runnable {
    //考虑线程安全问题，准备一个锁对象
    Object object = new Object();
    @Override
    public void run() {
        synchronized (object) {
            System.out.println("我是一个游泳教练！");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("教练来了！" + Thread.currentThread().getName());
            System.out.println("教我游泳,教会后，教练又回到了游泳池");
        }

    }
}
