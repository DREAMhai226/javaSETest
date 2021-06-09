package demo01.reader;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 11:22
 */
public class CharacterStream {
    public static void main(String[] args) throws IOException {
        //FileInputStream为操作文件的字符输入流
        FileInputStream f = new FileInputStream("IOWrite2.txt");
        int len = 0;
        while ((len = f.read()) != -1) {
            System.out.print((char) len);
        }

    }
}
