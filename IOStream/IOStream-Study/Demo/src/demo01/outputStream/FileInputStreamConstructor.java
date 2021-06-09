package demo01.outputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 10:04
 */
public class FileInputStreamConstructor {
    public static void main(String[] args) throws FileNotFoundException {
        //使用File对象创建流对象
        File f1 = new File("aaa.txt");
        FileInputStream fileInputStream = new FileInputStream(f1);

        //使用文件名创建流对象
        FileInputStream fileInputStream1 = new FileInputStream("test.txt");
    }
}
