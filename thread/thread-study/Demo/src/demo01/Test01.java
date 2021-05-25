package demo01;

/**
 * @Author HL Zhou
 * @Date 2021/5/10 22:28
 */

/**方式一
 * a.创建Thread类
 * b.重写run()方法
 * c.调用start()开启线程
 */
public class Test01 extends Thread{
    @Override
    public void run(){
        /**
         * run方法线程体
         */
        for (int i = 0; i < 300; i++) {
            System.out.println("声音");
        }
    }
    public static void main(String[] args) {
        /**
         * main()主线程
         */
        //创建一个线程对象
        Test01 test01 = new Test01();
        //先执行run()方法，执行完run()方法后再执行main()方法
        test01.run();
        //调用start()方法，两个线程同期执行，每次输出的结构随机
        //test01.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("视频画面");
        }
    }
}
