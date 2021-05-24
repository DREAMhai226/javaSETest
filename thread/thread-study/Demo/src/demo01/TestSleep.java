package demo01;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * @Author HL Zhou
 * @Date 2021/5/11 20:31
 */
public class TestSleep {
    public static void main(String[] args) {
        //模拟网络延时
        /*try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //获取当前时间
        Date startTime  = new Date(System.currentTimeMillis());
        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                //更新当前时间
                startTime = new Date(System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }
}
