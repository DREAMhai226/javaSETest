package demo01;

import java.io.File;

/**
 * @Author HL Zhou
 * @Date 2021/5/25 11:08
 */
public class FileGet {
    public static void main(String[] args) {
        File f = new File("E:\\Java\\javaSE\\thread\\thread-study\\笔记\\多线程.md");
        System.out.println("文件的绝对路径：" + f.getAbsolutePath());
        System.out.println("文件构造路径：" + f.getPath());
        System.out.println("文件名称：" + f.getName());
        System.out.println("文件长度：" + f.length() + "字节");

        File f2 = new File("E:\\Java\\javaSE\\thread\\thread-study\\笔记");
        System.out.println("目录的绝对路径：" + f2.getAbsolutePath());
        System.out.println("目录构造路径：" + f2.getPath());
        System.out.println("目录名称：" + f2.getName());
        System.out.println("目录长度：" + f2.length());
    }
}
