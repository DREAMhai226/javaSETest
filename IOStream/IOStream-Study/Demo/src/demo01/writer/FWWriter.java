package demo01.writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 22:43
 */
public class FWWriter {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileWriter fw = new FileWriter("FW.txt");
        //写出数据
        fw.write(97);
        fw.write('b');
        fw.write('c');
        fw.close();
    }
}
