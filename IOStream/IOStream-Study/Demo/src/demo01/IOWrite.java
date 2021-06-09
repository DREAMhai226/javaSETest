package demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/26 11:23
 */
public class IOWrite {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建对象
        FileOutputStream f1 = new FileOutputStream("test.txt");
        //写出数据
        f1.write(97);
        f1.write(98);
        f1.write(99);
        f1.write(100);
        //关闭资源
        f1.close();
    }
}
