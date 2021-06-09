package demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/26 11:31
 */
public class IOWrite2 {
    public static void main(String[] args) throws IOException {
        //使用文件流创建对象
        FileOutputStream f1 = new FileOutputStream("IOWrite2.txt");
        //字符串转换成字符数组
        byte[] bytes = "南京航空航天大学".getBytes();
        //写出字符数组数据
        f1.write(bytes);
        //关闭资源
        f1.close();
    }
}
