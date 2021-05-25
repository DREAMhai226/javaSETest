package demo01;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author HL Zhou
 * @Date 2021/5/12 23:17
 */
public class ThreadSecurity {
    public static void main(String[] args) {
        RunnableDemo runn = new RunnableDemo();

        Thread thread1 = new Thread(runn, "第一个线程");
        Thread thread2 = new Thread(runn, "第二个线程");
        Thread thread3 = new Thread(runn, "第三个线程");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
//会出现线程安全问题，同意资源被多个线程获取
/*class RunnableDemo implements Runnable{
    //线程共享资源数据
    public int a = 100;
    @Override
    public void run() {
        while (a > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "执行到" + a + "次！");
            a--;
        }
    }
}*/
//方式一：采用同步代码快解决线程安全问题
class RunnableDemo implements Runnable {
    //线程共享资源数据
    public int a = 100 ;
    //先准备一个锁对象
    final Object object = new Object();
    @Override
    public void run() {
        synchronized (object) {
            while (a > 0) {
                System.out.println(Thread.currentThread().getName() + "执行到" + a + "次！");
                a--;
            }
        }
    }
}
//方式二：采用同步方法解决线程安全问题
/*class RunnableDemo implements Runnable {
    //线程共享资源数据
    public int a = 100;
    @Override
    public void run() {
        while (true) {
            //调用sell()方法
            sell();
        }
    }
    //将访问了共享数据的代码抽取出来，放到一个方法体中
    public synchronized void sell(){
        while (a > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "执行到" + a + "次！");
            a--;
        }
    }
}*/
//方式三：采用锁解决线程安全问题
/*class RunnableDemo implements Runnable {
    //线程共享资源数据
    public int a = 100;
    //1,在Runnable实现类的成员变量中创建一个ReentrantLock锁
    ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        //2，在可能产生线程安全问题的代码前该对象调用lock方法获取锁
        reentrantLock.lock();
        while (a > 0) {
            System.out.println("线程" + Thread.currentThread().getName() + "执行到" + a + "次！");
            a--;
        }
        // 3、在可能产生线程安全问题的代码后该对象调用unlock方法释放锁
        reentrantLock.unlock();
    }
}*/
/*
class RunnableDemo implements Runnable {
    //线程共享资源数据
    public int a = 100;
    //1,在Runnable实现类的成员变量中创建一个ReentrantLock锁
    ReentrantLock reentrantLock = new ReentrantLock();
    @Override
    public void run() {
        //2，在可能产生线程安全问题的代码前该对象调用lock方法获取锁
        reentrantLock.lock();
        try {
            while (a > 0) {
                //Thread.yield();
                System.out.println("线程" + Thread.currentThread().getName() + "执行到" + a + "次！");
                a--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3、在可能产生线程安全问题的代码后该对象调用unlock方法释放锁
            reentrantLock.unlock();
        }
    }
}*/
