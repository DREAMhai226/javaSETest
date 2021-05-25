package demo01;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;

import java.io.File;

/**
 * @Author HL Zhou
 * @Date 2021/5/25 20:10
 */
public class FileFor {
    public static void main(String[] args) {
        File dir = new File("E:\\Java\\javaSE");
        //获取当前目录下文件和文件夹名称
        String[] name = dir.list();
        for (String n : name) {
            System.out.println(n);
        }

        //获取当前目录下的文件及文件夹对象，只要拿到了文件对象，可以有更多的操作
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }
}
