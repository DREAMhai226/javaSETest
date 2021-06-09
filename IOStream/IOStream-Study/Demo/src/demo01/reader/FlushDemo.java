package demo01.reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 22:56
 */
public class FlushDemo {
    public static void main(String[] args) throws IOException {
        //源 输入流 读取文件数据
        FileReader fr = new FileReader("a.txt");
        //目的地 输出流
        FileWriter fw = new FileWriter("b.txt");
        int len = 0;
        while ((len = fr.read()) != -1) {
            fw.write(len);
        }
        fr.close();
        fw.flush();
        fw.close();
    }
}
