package demo01;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/26 20:56
 */
public class IOWrite5 {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建流对象
        FileOutputStream f = new FileOutputStream("aaa.txt");
        //定义字节数组
        byte[] bytes = {'a', 'x', 'c', 'c'};
        //遍历数组
        for (int i = 0; i < bytes.length; i++) {
            //写出一个字节
            f.write(bytes[i]);
            //写出一个换行, 换行符号转成数组写出
            f.write("\r\n".getBytes());
        }
        //关闭资源
        f.close();
    }
}
