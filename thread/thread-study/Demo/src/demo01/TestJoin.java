package demo01;

/**
 * @Author HL Zhou
 * @Date 2021/5/12 22:41
 */
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("VIP线程");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        for (int i = 0; i < 1000; i++) {
            if (i == 200) {
                thread.start();
                thread.join();
            }
            System.out.println("主线程main执行第" + i + "次！");
        }
    }
}
