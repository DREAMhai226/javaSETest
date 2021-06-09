package demo01.reader;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 21:13
 */
public class FRRead {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileReader fr = new FileReader("a.txt");
        //定义变量保存数据
        int len = 0;
        //定义数组
        char[] chars = new char[1024];
        //循环遍历
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0,len));
        }
        //关闭资源
        fr.close();
    }
}
