package demo01;

import java.io.File;

/**
 * @Author HL Zhou
 * @Date 2021/5/25 11:23
 */
public class FilePath {
    public static void main(String[] args) {
        File f1 = new File("E:\\aaa.txt");
        System.out.println(f1.getAbsoluteFile());

        File f2 = new File("aaa.txt");
        System.out.println(f2.getAbsoluteFile());
    }
}
