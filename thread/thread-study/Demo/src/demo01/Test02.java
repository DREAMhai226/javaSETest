package demo01;

/**
 * @Author HL Zhou
 * @Date 2021/5/11 10:19
 */
public class Test02 implements Runnable{
    //票数
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true){
            if(ticketNums <= 0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->拿到了" + ticketNums + "票");
        }
    }

    public static void main(String[] args) {
        Test02 ticket = new Test02();
        new Thread(ticket, "小明").start();
        new Thread(ticket, "老师").start();
        new Thread(ticket, "黄牛").start();
    }
}
