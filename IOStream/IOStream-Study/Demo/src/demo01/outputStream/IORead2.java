package demo01.outputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 10:28
 */
public class IORead2 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileInputStream f = new FileInputStream("test.txt");//test的文件内容为abcde
        //定义变量作为有效个数
        int len;
        //定义字节数组，作为装字节数据的容器
        byte[] bytes = new byte[2];
        //循循环读取
        while ((len = f.read(bytes)) != -1) {
            System.out.println((new String(bytes)));
        }
        //关闭资源
        f.close();
    }
}
