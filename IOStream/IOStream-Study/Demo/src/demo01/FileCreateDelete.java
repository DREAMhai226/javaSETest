package demo01;

import java.io.File;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/25 19:22
 */
public class FileCreateDelete {
    public static void main(String[] args) throws IOException {
        //文件的创建
        File f1 = new File("bbb.txt");
        System.out.println("bbb.txt是否存在：" + f1.exists());//false 不存在
        System.out.println("bbb.txt是否创建：" + f1.createNewFile());//true 需要创建
        System.out.println("bbb.txt是否创建：" + f1.createNewFile());//false 已经创建了，不需要再创建
        System.out.println("bbb.txt是否存在：" + f1.exists());//true 创建了，所以存在

        //目录的创建
        File f2 = new File("newDir");
        System.out.println("newDir是否存在：" + f2.exists());//false
        System.out.println("newDir是否创建：" + f2.createNewFile());//true
        System.out.println("newDir是否存在：" + f2.exists());//true

        //创建多级目录
        File f3 = new File("newDira\\newDirb");
        System.out.println(f3.mkdir());//false
        File f4 = new File("newDira\\newDirb");
        System.out.println(f4.mkdirs());//true
        //创建多级目录
        File f5 = new File("newDira1\\newDirb1");
        System.out.println(f5.mkdir());//false
        System.out.println(f5.mkdirs());//true

        //文件的删除
        System.out.println(f1.delete());//true

        //目录的删除
        System.out.println(f2.delete());//true
        System.out.println(f5.delete());//true
        System.out.println(f4.delete());//true
        File file = new File("E:\\aaa");
        System.out.println(file.delete());//false
    }
}
