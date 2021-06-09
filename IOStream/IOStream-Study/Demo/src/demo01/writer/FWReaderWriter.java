package demo01.writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/28 9:21
 */
public class FWReaderWriter {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建输入流对象和输出流对象
        FileReader fr = new FileReader("FW.txt");
        FileWriter fw = new FileWriter("a.txt");
        //文本文件复制，一次一个字符
        copyMethod1(fr, fw);
        //文本文件复制，一次一个字符数组
        copyMethod2(fr, fw);
        fr.close();
        fw.close();


    }
    //文本文件复制，一次一个字符
    public static void copyMethod1(FileReader fr, FileWriter fw) throws IOException {
        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }
        fw.close();
    }

    //文本文件复制，一次一个字符数组
    public static void copyMethod2(FileReader fr, FileWriter fw) throws IOException {
        int len = 0;
        //创建一个数组
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            fw.write(chars,0,len);
        }
        fw.close();
    }
}
