package demo01.reader;

import java.io.*;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 20:59
 */
public class FileReaderConstructor {
    public static void main(String[] args) throws IOException {
        //使用File对象创建流对象
        File file = new File("a.txt");
        FileReader fileReader = new FileReader(file);

        //使用文件名创建流对象
        FileReader fileReader1 = new FileReader("b.txt");
    }
}
