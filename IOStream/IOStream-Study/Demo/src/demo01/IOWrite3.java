package demo01;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/26 20:34
 */
public class IOWrite3 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileOutputStream f = new FileOutputStream("IOWrite3.txt");
        //字符串转换成字节数组
        byte[] bytes = "abcdddd".getBytes();
        //写出数据
        f.write(bytes,0,3);//从0开始，一共3个字节
        //关闭资源
        f.close();

    }
}
