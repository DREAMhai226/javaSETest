package demo01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Author HL Zhou
 * @Date 2021/5/26 11:05
 */
public class FileOutputStreamConstructor {
    public static void main(String[] args) throws FileNotFoundException {
        //使用File对象创建流对象
        File file = new File("E:\\java\\c.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        //使用文件名称创建对象
        FileOutputStream fileOutputStream1 = new FileOutputStream("E:\\b.txt");
    }
}
