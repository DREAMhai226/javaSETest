package demo01.reader;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 11:26
 */
public class CharacterStream2 {
    public static void main(String[] args) throws IOException {
        //FileInputStream为操作文件的字符输入流
        FileInputStream f = new FileInputStream("IOWrite2.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = f.read(bytes)) != -1) {
            System.out.print(new String(bytes,0,len));
        }
    }
}
