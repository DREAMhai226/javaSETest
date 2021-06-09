package demo01;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/26 20:52
 */
public class IOWrite4 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileOutputStream f = new FileOutputStream("IOWrite3.txt",true);
        //字符串转换成字节数组
        byte[] bytes = "12345".getBytes();
        //写出数据
        f.write(bytes);
        //关闭资源
        f.close();

    }
}
