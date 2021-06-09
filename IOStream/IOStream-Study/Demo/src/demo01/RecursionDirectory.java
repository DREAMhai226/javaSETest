package demo01;

import java.io.File;

/**
 * @Author HL Zhou
 * @Date 2021/5/25 20:33
 */
public class RecursionDirectory {
    public static void main(String[] args) {
        File file = new File("E:\\Java\\javaSE");
        Recursion(file);
    }
    public static void Recursion(File file) {
        //1、判断是否为目录
        if(!file.isDirectory()) {
            return;
        }
        //2、确认File是目录
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                //还是目录的话就递归
                Recursion(f);
            }else {
                //3、确认是个文件，则输出文件的名称
                System.out.println(f.getName());
            }
        }
    }
}
