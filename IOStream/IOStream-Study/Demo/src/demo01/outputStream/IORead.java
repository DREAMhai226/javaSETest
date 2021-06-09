package demo01.outputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 10:14
 */
public class IORead {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建流对象
        FileInputStream f = new FileInputStream("test.txt");//test的内容为abcd
        //定义变量保存数据
        int b;
        while ((b = f.read()) != -1) {
            System.out.println((char) b);
        }
        //关闭资源
        f.close();
    }
}
