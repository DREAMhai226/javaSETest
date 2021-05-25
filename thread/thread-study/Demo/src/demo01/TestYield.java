package demo01;

/**
 * @Author HL Zhou
 * @Date 2021/5/12 22:30
 */
public class TestYield {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "第一个线程").start();
        new Thread(myYield, "第二个线程").start();
    }
}
class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始执行！");
        //礼让
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "停止执行！");
    }
}
