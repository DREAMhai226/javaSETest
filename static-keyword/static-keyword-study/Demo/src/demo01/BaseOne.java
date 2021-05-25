package demo01;

import javax.swing.*;
import java.net.SocketTimeoutException;

/**
 * @Author HL Zhou
 * @Date 2021/5/15 20:39
 */
public class BaseOne {
    public BaseOne() {
        System.out.println("BaseOne构造器！");
    }
    {
        System.out.println("BaseOne初始化块！");
        System.out.println();
    }
    static {
        System.out.println("BaseOne静态初始化块！");
    }
}
