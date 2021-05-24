package demo01;

import javax.swing.*;

/**
 * @Author HL Zhou
 * @Date 2021/5/11 20:12
 */
public class TestStop implements Runnable{
    //设置一个标志位
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag) {
            i++;
            System.out.println("run Thread" + i + "次！" );
        }
    }
    //设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag = false;
    }
    public static void main(String[] args) {
        TestStop stop = new TestStop();
        new Thread(stop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if(i == 800){
                //调用stop方法切换标志位，让线程停止
                stop.stop();
                System.out.println("线程终止了！");
            }
        }
    }
}
