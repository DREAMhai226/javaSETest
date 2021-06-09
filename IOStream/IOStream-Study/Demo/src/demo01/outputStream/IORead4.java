package demo01.outputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 10:50
 */
public class IORead4 {
    public static void main(String[] args) {
        //1创建流对象
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            //1.1指定数据源
            fileInputStream = new FileInputStream("下载.png");
            //1.2指定目的地
            fileOutputStream = new FileOutputStream("复制.png");
            //2读取数据
            //2.1定义数组
            byte[] bytes = new byte[1024];
            //2.2定义长度
            int len = 0;
            //2.3循环数据
            while ((len = fileInputStream.read(bytes)) != -1) {
                //2.4写出数据
                fileOutputStream.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //3关闭资源
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
