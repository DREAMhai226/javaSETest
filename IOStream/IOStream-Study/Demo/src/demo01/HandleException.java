package demo01;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/28 10:06
 */
public class HandleException {
    public static void main(String[] args) {
        //声明变量
        FileWriter fw = null;
        FileReader fr = null;
        //创建流对象
        try {
            fw = new FileWriter("FW.txt");
            fr = new FileReader("a.txt");
            //写出数据
            fw.write("南京航空航天大学");
            char[] chars = new char[1024];
            int len = 0;
            while ((len = fr.read(chars)) != -1) {
                System.out.print(new String(chars,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
