package demo01;

import java.io.File;

/**
 * @Author HL Zhou
 * @Date 2021/5/25 19:00
 */
public class FileIs {
    public static void main(String[] args) {
        File f1 = new File("E:\\aaa.txt");
        File f2 = new File("E:\\aaa");
        //判断是否存在
        System.out.println("文件是否存在：" + f1.exists());
        System.out.println("目录是否存在：" + f2.exists());

        //判断是文件还是目录
        System.out.println("E:\\aaa是文件吗？" + f2.isFile());
        System.out.println("E:\\aaa是目录吗？" + f2.isDirectory());
    }
}
