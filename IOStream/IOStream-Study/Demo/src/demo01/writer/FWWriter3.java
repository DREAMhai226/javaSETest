package demo01.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/28 9:14
 */
public class FWWriter3 {
    public static void main(String[] args) throws IOException {
        //使用摁键名称创建流对象
        FileWriter fw = new FileWriter("FW.txt",true);
        //写出数据
        fw.write("学院");
        //换行
        fw.write("\r\n");
        fw.write("大学");
        //关闭资源
        fw.close();
    }
}
