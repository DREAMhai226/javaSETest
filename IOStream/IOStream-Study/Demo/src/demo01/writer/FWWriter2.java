package demo01.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 23:07
 */
public class FWWriter2 {
    public static void main(String[] args) throws IOException {
        //使用文件名称来创建流对象
        FileWriter fw = new FileWriter("FW.txt");
        //写出数据，通过flush
        fw.write("航");
        fw.flush();
        fw.write("空");
        fw.flush();

        //写出数据，通过clone
        fw.write("航");
        fw.close();
        //fw.write("天");// 继续写出第2个字符,【报错】java.io.IOException: Stream closed
        fw.close();
    }
}
