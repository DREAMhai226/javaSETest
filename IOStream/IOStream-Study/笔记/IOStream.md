# IO流概述
* 1、明确要操作的数据是数据源还是数据目的(读/写)  
> 源：InputStream Reader  
> 目的：OutputStream Writer
* 2、明确要操作的设备上的数据是字节还是文本
> 源：  
> 字节：InputStream   
> 文本：Reader  
 
> 目的：  
> 字节：OutputStream  
> 文本：Writer  
* 3、明确数据所在的具体设备
> 源设备：  
> 硬盘：文件``File``开头  
> 内存：数组、字符串  
> 键盘：``System in``  
> 网络：``Socket``  

> 对应目的设备：  
> 硬盘：文件``File``开头  
> 内存：数组、字符串  
> 键盘：``System out``  
> 网络：``Socket``   
* 4、明确是否需要额外功能
> 需要转换：转换流InputStreamReader、OutputStreamWriter
> 需要高效：缓冲流Buffered
> 保证数据的输出格式：打印流PrintStream、PrintWriter  
>
**IO流的分类**
![image](https://cdn.jsdelivr.net/gh/DREAMhai226/image-hosting@master/image-java/image.3b06nhouhw80.png)
***
# 2、File类
## 2.1 概述
``java.io.File``类是专门对文件进行操作的类，只能对文件本身进行操作，不能对文件内容进行操作。  
``java.io.File``类是文件和目录路径的抽象表示，主要用于文件和目录的创建、查找和删除。  
## 2.2 构造方法
* 1、``public File(String pathname``：通过将给定的**路径名字符串**转换成抽象路径名来创建新的File实例。
* 2、``public File(String parent, String child``：从**父路径名字符串和子路径名字符串**创建新的File实例。
* 3、``public File(File parent, String child``：从**父抽象路径名和子路径名字符串**创建新的File实例。
```java
1. 一个File对象代表硬盘中实际存在的一个文件或者目录。
2.  File类构造方法不会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，都不影响File对象的创建。
// 文件路径名 
String path = "D:\\123.txt";
File file1 = new File(path); 

// 文件路径名
String path2 = "D:\\1\\2.txt";
File file2 = new File(path2);     -------------相当于D:\\1\\2.txt

// 通过父路径和子路径字符串
 String parent = "F:\\aaa";
 String child = "bbb.txt";
 File file3 = new File(parent, child);  --------相当于F:\\aaa\\bbb.txt

// 通过父级File对象和子路径字符串
File parentDir = new File("F:\\aaa");
String child = "bbb.txt";
File file4 = new File(parentDir, child); --------相当于F:\\aaa\\bbb.txt
```
> File类的注意点：
> 1、一个File对象代表键盘中实际存在一个文件或目录。  
> 2、File类构造方法不会给你检验这个文件或文件夹是否真实存在，因此无论该路径下是否存在文件或者目录，
>都不影响File对象的创建。  
## 2.3 常用方法
* 获取功能
* 获取绝对路径和相对路径
* 判断功能
* 创建删除功能
### 2.3.1 获取功能的方法
* 1、``public String getAbsolutePath()``：返回此File的绝对路径名字符串。
* 2、``public String getPath()``：将此File转换为路径名字符串。
* 3、``public String getName()``：返回由此File表示的文件或目录的名称。
* 4、``public long length()``：返回由此File表示的文件的长度。
```java
package demo01;

import java.io.File;

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
```
>注意：``length()``，表示文件的长度。但是``File``对象表示目录，则返回值未指定。
### 2.3.2 绝对路径和相对路径
**绝对路径**：一个完整的路径，以盘符开头，例如``E://aaa.txt``。  
**相对路径**：一个简化的路径，不以盘符开头，例如``//aaa.txt//b.txt``。
> 1、**路径不区分大小写**
> 2、路径中的文件名称分隔符windows使用反斜杠,反斜杠是转义字符,两个反斜杠代表一个普通的反斜杠
```java
package demo01;

import java.io.File;

public class FilePath {
    public static void main(String[] args) {
        File f1 = new File("E:\\aaa.txt");
        System.out.println(f1.getAbsoluteFile());

        File f2 = new File("aaa.txt");
        System.out.println(f2.getAbsoluteFile());
    }
}
```
>输出结果：  
>E:\aaa.txt  
>E:\Java\javaSE\IOStream\IOStream-Study\aaa.txt  
### 2.3.3 判断功能的方法
* 1、``public boolean exists()``：此File表示的文件或目录是否实际存在。
* 2、``public boolean isDirectory()``：此File是否为目录。
* 2、``public boolean isFile()``：此File是否为文件。
```java
package demo01;

import java.io.File;

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
```
>运行结果：  
> 文件是否存在：true  
 目录是否存在：true  
 E:\aaa是文件吗？false  
 E:\aaa是目录吗？true  

### 2.3.4 创建删除功能的方法
* 1、``public boolean creatNewFile()``：文件不存在，创建一个新的文件夹并返回``true``；文件存在，不创建文件
并返回``false``。
* 2、``public boolean delete()``：删除此File表示的文件或目录。
* 3、``public boolean mkdir()``：创建由此File表示的目录。
* 4、``public boolean mkdirs()``：创建由此File表示的目录，**可以创建多级目录**。***开发中一般使用***``mkdirs()``。
```java
package demo01;

import java.io.File;
import java.io.IOException;

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
```
>注意：``delete``方法，如果File表示目录，目录必须为空才能删除
## 2.4 目录的遍历
* ``public String[] list()``：返回一个String数组，表示File目录中的所有子文件或目录。  
* ``public File[] listFiles()``：返回一个File数组，表示File目录中的所有子文件或目录。    
```java
package demo01;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;
import java.io.File;

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
```
>运行结果：
>.git
 .gitattributes
 exception
 IOStream
 static-keyword
 thread
 E:\Java\javaSE\.git
 E:\Java\javaSE\.gitattributes
 E:\Java\javaSE\exception
 E:\Java\javaSE\IOStream
 E:\Java\javaSE\static-keyword
 E:\Java\javaSE\thread

<font color=#FF0000>listFiles</font>在获取指定目录下的文件或者文件夹必须满足下面两个条件：
* 1、<font color=#FF0000>指定目录必须存在</font
* 2、<font color=#FF0000>指定必须是目录，否则容易引发数组为null，出现NullPointerException空指针异常</font>

## 2.5 递归遍历文件夹下所有文件及子文件
```java
package demo01;

import java.io.File;

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
```
***
# 3、IO流
## 3.1 IO的概念
java中I/O操作主要是指使用``java.io``包下的内容，进行输入输出操作。<font color=red>输入也叫读取数据，输出
叫写出数据</font>。以内存为基准，分为``输入input``和``输出output``
## 3.2 IO的分类
根据数据流向分为：<font color=red>输入流</font>和<font color=red>输出流</font>。
* **输入流**：把数据从``其他设备``上读取到``内存``中的流。
* **输出流**：把数据从``内存``中写出到``其他设备``上的流。  

根据数据类型分为：<font color=red>字节流</font>和<font color=red>字符流</font>。
* **字节流**：以字节为单位，读写数据的流。
* **字符流**：以字符为单位，读写数据的流。

**分类后对应的超类(父类)**：  

|       |  输入流                |  输出流                |
| :---:  | :----:                  | :----:             |
| 字节流 |  字节输入流InputStream  |  字节输出流OutputStream |
| 字符流 |     字符输入流 Reader    |  字符输出流 Writer     |

注意：<font color=red>这四个类的子类名称都是以其父类名称作为子类名称的后最</font>  
如：InputStream的子类FileInputStream.
![image](https://cdn.jsdelivr.net/gh/DREAMhai226/image-hosting@master/image-java/image.7hm3sbi7tk80.png)
## 3.3 IO的分流说明
![image](https://cdn.jsdelivr.net/gh/DREAMhai226/image-hosting@master/image-java/image.44g8xqy6sla0.png)
![image](https://cdn.jsdelivr.net/gh/DREAMhai226/image-hosting@master/image-java/image.2he0lgfwesm0.png)
***
# 4、字节流
OutputStream和InputStream的继承关系
![image](https://cdn.jsdelivr.net/gh/DREAMhai226/image-hosting@master/image-java/image.6op8pvx3dxs0.png)
## 4.1 文件里皆为字节
一切文件数据(文本、图片、视频等)在存储时，都是以二进制数字的形式保存，都一个一个的字节，那么传输时一样如此。
所以，字节流可以传输任意文件数据。在操作流的时候，我们要时刻明确，无论使用什么样的流对象，底层传输的始终为
**二进制**数据。
## 4.2 字节输出流(OutputStream)
``java.io.OutputStream``抽象类是表示**字节输出流**的所有类的**超类**。将指定的字节信息写出到目的地。
它定义了字节输出流的基本共性功能方法，
**字节输出流的基本共性功能方法**
>1、``public void close()``：关闭此输出流并释放与此流相关联的任何系统资源。  
>2、``public void flush()``：刷新此输出流并强制任何缓冲的输出字节流被写出。  
>3、``public void write(byte[] b)``：将b.length个字节从指定的字节数组写入此输出流。   
>4、``public void write(byte[] b, int off, int len)``：从指定的字节数组写入 len字节，从偏移量 
>off开始输出到此输出流。 也就是说从off个字节数开始读取一直到len个字节结束。  
>5、`public abstract void write(int b)`：将指定的字节输出流.  
><font color=red>以上五个方法则是字节输出流都具有的方法，由父类OutputStream定义提供，子类都会共享以上方法</fomnt>

**FileOutputStream类**
`OutputStream`有很多子类，FileOutputStream是文件输出流，用于将数据写出到文件。
**FileOutputStream**构造方法  
只要是对象，就从构造方法开始。  
>1、`public FileOutputStream(File file)`：根据**File对象**为参数创建对象。
>2、`public FileOutputStream(String name)`：根据**名称字符串**为参数创建对象。

<font color=red>在开发中，推荐使用第二种构造方法</font>
>FileOutputStream outputStream = new FileOutputStream("abc.txt");  
 
根据上面的代码，类似这样创建字节输出流对象做了**三件事情**：
* 1、调用系统功能去创建文件[输出流对象才会自动创建]
* 2、创建OutputStream对象  
* 3、将OutputStream对象指向这个文件

>注意：
>创建输出流对象的时候，系统会自动**先**去对应位置创建对应文件，而创建输出流对象的时候，
>文件不存在则会报FileNotFoundException异常，也就是系统找不到指定的文件异常。

当你创建一个流对象时，必须直接或者间接传入一个文件路径。比如现在我们创建一
个FileOutputStream流对象，在该路径下，如果没有这个文件，会创建该文件。
如果有这个文件，会清空这个文件的数据。有兴趣的童鞋可以测试一下，具体代码如下：
```java
package demo01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputStreamConstructor {
    public static void main(String[] args) throws FileNotFoundException {
        //使用File对象创建流对象
        File file = new File("E:\\java\\c.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        
        //使用文件名称创建对象
        FileOutputStream fileOutputStream1 = new FileOutputStream("E:\\b.txt");
    }
}
```
**FileOutputStream写出字节数据**
主要通过下面三种`write`方法
>1、public void write(int b0)
>2、public void write(byte[] b)
>3、public void write(byte[] b, int off, int len) 从off开始，len个字节

* 1、**写出字节**：`write(int b)`方法，每次写出一个字节数据，代码如下：  
```java
package demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOWrite {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建对象
        FileOutputStream f1 = new FileOutputStream("test.txt");
        //写出数据
        f1.write(97);
        f1.write(98);
        f1.write(99);
        f1.write(100);
        //关闭资源
        f1.close();
    }
}
```
>输出结果：  
>abcd

>1、虽然参数为int类型四个字节，但是只会保留一个字节的信息写出。
>2、流操作完毕后，必须释放系统资源，调用close方法，千万记得。  

* 2、**写出字节数组**：`write(byte[] b)`方法，每次可以写出数组中的数据，代码如下：  
```java
package demo01;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOWrite2 {
    public static void main(String[] args) throws IOException {
        //使用文件流创建对象
        FileOutputStream f1 = new FileOutputStream("IOWrite2.txt");
        //字符串转换成字符数组
        byte[] bytes = "南京航空航天大学".getBytes();
        //写出字符数组数据
        f1.write(bytes);
        //关闭资源
        f1.close();
    }
}
```
>输出结果：  
>南京航空航天大学
* 3、写出指定长度的字符数组`write(byte[] b, int off, int len)`，从off开始，len个字节，代码如下：
```java
package demo01;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOWrite3 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileOutputStream f = new FileOutputStream("IOWrite3.txt");
        //字符串转换成字节数组
        byte[] bytes = "abcdddd".getBytes();
        //写出数据
        f.write(bytes,0,3);//从0开始，一共3个字节
        //关闭资源
        f.close();

    }
}
```
>输出结果：  
>abc

**FileOutputStream实现数据追加续写、换行
* 1、`public FileOutputStream(File file, boolean apppend)`  
* 2、`public FileOutputStream(String name, boolean apppend)`  
`true`表示追加数据，`false`表示不追加数据，即清空原有数据
实现数据追加续写代码如下：
```java
package demo01;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOWrite4 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileOutputStream f = new FileOutputStream("IOWrite3.txt",true);
        //字符串转换成字节数组
        byte[] bytes = "12345".getBytes();
        //写出数据
        f.write(bytes);
        //关闭资源
        f.close();

    }
}
```
>输出结果：  
>abc12345

Windows系统里，换行符号是`\r\n` ,具体代码如下：
```java
package demo01;

import java.io.FileOutputStream;
import java.io.IOException;

public class IOWrite5 {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建流对象
        FileOutputStream f = new FileOutputStream("aaa.txt");
        //定义字节数组
        byte[] bytes = {'a', 'x', 'c', 'c'};
        //遍历数组
        for (int i = 0; i < bytes.length; i++) {
            //写出一个字节
            f.write(bytes[i]);
            //写出一个换行, 换行符号转成数组写出
            f.write("\r\n".getBytes());
        }
        //关闭资源
        f.close();
    }
}
```
>输出结果：  
>a  
>x  
 c  
 c  

>* 回车符`\r`和换行符`\n`
>   * 回车符：回到一行的开头(return)
>   * 换行符：下一行(newline)
>* 系统中的换行
>   * Windows：`回车`+`换行`，即`\r\n`；
>   * Unix：`换行`，即`\n`；
>   * Mac：`回车`，即`\r`，从 Mac OS X开始与Linux统一。

## 4.3 字节输入流(InputStream)
`java.io.InputStream`抽象类是表示**字节输入流**的所有超类，可以读取字节信息到内存中，定义了字节输入流的
基本共性功能方法。
>1、`public void close()`：关闭此输入流并释放与此输入流相关的任何系统资源。
>2、`public abstract int read()`：从输入流读取数据的下一个字节。
>3、`public int read(byte[] b)`：读取指定b个字节的数据，读几个返回几个，读不到就返回-1

**FileInputStream**类
`java.io.FileInputStream`类是文件输入流，从文件中读取字节。
**FileInputStream**的构造方法
>1、FileInputStream(File file)：通过打开与实际文件的连接来创建一个FileInputStream，该文件由文件系统中的File对象
>file命名。
>2、FileInputStream(String name)：通过打开与实际文件的连接来创建一个FileInputStream，该文件由系统中的路径
>名name命名。

<font color=red>推荐使用第二种方法：</font>
>FileInputStream inputStream = new FileInputStream("a.txt");

```java
package demo01.outputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 10:04
 */
public class FileInputStreamConstructor {
    public static void main(String[] args) throws FileNotFoundException {
        //使用File对象创建流对象
        File f1 = new File("aaa.txt");
        FileInputStream fileInputStream = new FileInputStream(f1);

        //使用文件名创建流对象
        FileInputStream fileInputStream1 = new FileInputStream("test.txt");
    }
}
```
**FileInputStream读取字节数据**
    1、**读取字节**：`read`方法可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回`-1`.
```java
package demo01.outputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class IORead {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建流对象
        FileInputStream f = new FileInputStream("test.txt");//test的内容为abcd
        //定义变量保存数据
        int b;
        while ((b = f.read()) != -1) {
            System.out.println((char) b);
        }
        //关闭资源
        f.close();
    }
}
输出结果：
a
b
c
d
```
**2、使用字节数组读取**：`read (byte[] b)`，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回`-1` 。
```java
package demo01.outputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class IORead2 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileInputStream f = new FileInputStream("test.txt");//test的文件内容为abcde
        //定义变量作为有效个数
        int len;
        //定义字节数组，作为装字节数据的容器
        byte[] bytes = new byte[2];
        //循循环读取
        while ((len = f.read(bytes)) != -1) {
            System.out.println((new String(bytes)));
        }
        //关闭资源
        f.close();
    }
}
输出结果：
ab
cd
ed
```
由于`read.txt`文件中内容为`abcde`，而错误数据`d`，是由于最后一次读取时，
只读取一个字节`e`，数组中，上次读取的数据没有被完全替换【`注意是替换，看下图`】，所以要通过`len` ，获取有效的字节
![image](https://cdn.jsdelivr.net/gh/DREAMhai226/image-hosting@master/image-java/image.ht0lkb66v1s.png)

代码优化：
```java
package demo01.outputStream;

import java.io.FileInputStream;
import java.io.IOException;

public class IORead3 {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileInputStream f = new FileInputStream("test.txt");//test的文件内容为abcde
        //定义变量作为有效个数
        int len;
        //定义字节数组，作为装字节数据的容器
        byte[] bytes = new byte[2];
        //循循环读取
        while ((len = f.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //关闭资源
        f.close();
    }
}
输出结果：
ab
cd
e
```
<font color=red>在开发中强烈推荐使用数组读取文件</font>
**复制图片**
原理：
![image](https://cdn.jsdelivr.net/gh/DREAMhai226/image-hosting@master/image-java/image.3r3n8ijkkii0.png)

```java
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
```
***
# 5、字符流
## 5.1 字符流Reader和Writer概述
继承图：
![image](https://cdn.jsdelivr.net/gh/DREAMhai226/image-hosting@master/image-java/image.5qk46dmrcq40.png)
**字符流**的由来：因为数据编码不同，因而有了对数据高效操作的流对象，
字符流本质其实就是基于字节流读取时，去查了指定的码表，而字节流直接读取数据会有乱码的问题（读中文会乱码）
```java
package demo01.reader;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 11:22
 */
public class CharacterStream {
    public static void main(String[] args) throws IOException {
        //FileInputStream为操作文件的字符输入流
        FileInputStream f = new FileInputStream("IOWrite2.txt");//内容为：南京航空航天大学
        int len = 0;
        while ((len = f.read()) != -1) {
            System.out.print((char) len);
        }

    }
}
输出结果：
åäº¬èªç©ºèªå¤©å¤§å­¦
```
>字节流读取中文字符时，可能不会显示完整的字符，那是因为一个中文字符占用多个字节存储。

代码优化：
```java
package demo01.reader;

import java.io.FileInputStream;
import java.io.IOException;

public class CharacterStream2 {
    public static void main(String[] args) throws IOException {
        //FileInputStream为操作文件的字符输入流
        FileInputStream f = new FileInputStream("IOWrite2.txt");//内容为：南京航空航天大学
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = f.read(bytes)) != -1) {
            System.out.print(new String(bytes,0,len));
        }
    }
}
输出结果：
南京航空航天大学
```
分析：此时节码的是`String`，查看`new String()`的源码，String构造方法有`解码`功能，并且默认编码是`utf-8`，代码如下：
```java
this.value = StringCoding.decode(bytes, offset, length);
 
 再点进decode，循序渐进发现，默认编码是UTF-8
```
**如果处理纯文本的数据优先考虑字符流，其他情况就只能用字节流了（图片、视频、等等只文本例外）。**
>**字符流 = 字节流 + 编码表** 

## 5.2 字符输入流(Reader)
`java.io.Reader`抽象类是是**字符输入流**的所有类的**超类**
**字符输入流的共性方法**
>1、`public void close()`：关闭此流并释放与此流相关联的任何系统资源。
>2、`public int read()`：从输入流读取一个字符。
>3、`public int read(char[] cbuf)`：从输入流中读取一些字符，并将他们存储在字符数组`cbuf`中。

**FileReader**类
java.io.FileReader类是读取字符文件的变例类，构造和使用系统默认的字符编码和默认字节缓冲区。
**构造方法**
>1、`FileReader(File file)`：创建一个新的FileReader，给定要读取的**File对象**。
>2、`FIleReader(String fileName)`：创建一个新的FileReader，给定要读取文件的**字符串名称**。

```java
package demo01.reader;

import java.io.*;

public class FileReaderConstructor {
    public static void main(String[] args) throws IOException {
        //使用File对象创建流对象
        File file = new File("a.txt");
        FileReader fileReader = new FileReader(file);

        //使用文件名创建流对象
        FileReader fileReader1 = new FileReader("b.txt");
    }
}
```
**FileReader读取字符数据**
```java
package demo01.reader;

import java.io.FileReader;
import java.io.IOException;

public class FRRead {
    public static void main(String[] args) throws IOException {
        //使用文件名创建流对象
        FileReader fr = new FileReader("a.txt");
        //定义变量保存数据
        int len = 0;
        //定义数组
        char[] chars = new char[1024];
        //循环遍历
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars, 0,len));
        }
        //关闭资源 
        fr.close();
    }
}
```
## 字符输出流(Writer)
java.io.writer抽象类是**字符输出流**的所有类的**超类**，将指定的字符信息写出到目的地。它同样定义了字符输出流的基本共性功能方法。
>1、`public void writer(int c)`：写入单个字符
>2、`public void write(char[] cbuf)`：写入字符数组
>3、`public abstract write(char[] cbuf, int off, int len)`：写入字符数组的某一部分，off数组的开始索引,len写的字符个数。
>4、`public void write(String str)`：写入字符串。
>5、`public void write(String str, int off, int len)`：写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
>6、`public void flush()`：刷新该流的缓冲。
>7、`public void close()`：**关闭此流，但要先刷新它**? 答：关闭时会自动刷新

**FileWriter类**
`java.io.FileWriter`类是写出字符到文件的便利类，构造时使用系统默认的字符编码和默认字节缓冲区。
**构造方法**
>1、`FileWriter(File file)`： 创建一个新的 FileWriter，给定要读取的File对象。
>2、`FileWriter(String fileName)`： 创建一个新的 FileWriter，给定要读取的文件的名称。  

```java
public class FileWriterConstructor {
    public static void main(String[] args) throws IOException {
   	 	// 第一种：使用File对象创建流对象
        File file = new File("a.txt");
        FileWriter fw = new FileWriter(file);
      
        // 第二种：使用文件名称创建流对象
        FileWriter fw = new FileWriter("b.txt");
    }
}
输出结果：
abc
```
> <font color=red>【注意】关闭资源时,与FileOutputStream不同。 
>如果不关闭,数据只是保存到缓冲区，并未保存到文件。</font>

**关闭close和刷新flush**
因为内置缓冲区的原因，如果不关闭输出流，无法写出字符到文件中。
但是关闭的流对象，是无法继续写出数据的。如果我们既想写出数据，
又想继续使用流，就需要 `flush `方法了。  
>`flush`:刷新缓冲区，流对象可以继续使用。
>`close`：先刷新缓冲区，然后通知系统释放资源，流对象不可以再使用了。

```java
package demo01.reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 22:56
 */
public class FlushDemo {
    public static void main(String[] args) throws IOException {
        //源 输入流 读取文件数据
        FileReader fr = new FileReader("a.txt");
        //目的地 输出流
        FileWriter fw = new FileWriter("b.txt");
        int len = 0;
        while ((len = fr.read()) != -1) {
            fw.write(len);
        }
        //如果没有下面代码，a.txt的内容不会复制到b.txt中
        fr.close();
        fw.flush();
        fw.close();
    }
}
```
<font color=red>【注意】关闭资源时,与FileOutputStream不同。 如果不关闭,数据只是保存到缓冲区，并未保存到文件。</font>

>`flush()`这个函数是清空的意思，用于清空缓冲区的数据流，进行流的操作时，数据先被读到内存中，
>然后再用数据写到文件中，那么当你数据读完时，我们如果这时调用`close()`方法关闭读写流，
>这时就可能造成数据丢失，为什么呢？因为，读入数据完成时不代表写入数据完成，
>一部分数据可能会留在缓存区中，这个时候`flush()`方法就格外重要了。

flush和close使用代码如下：
```java
package demo01.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/27 23:07
 */
public class FWWriter2 {
    public static void main(String[] args) throws IOException {
        //使用文件名称来创建流对象
        FileWriter fw = new FileWriter("FW.txt");
        //写出数据，通过flush
        fw.write("航");
        fw.flush();
        fw.write("空");
        fw.flush();

        //写出数据，通过clone
        fw.write("航");
        fw.close();
        //fw.write("天");// 继续写出第2个字符,【报错】java.io.IOException: Stream closed
        fw.close();
    }
}
```
>即便是flush方法写出了数据，操作的最后还是要调用close方法，释放系统资源。

**FileWriter的续写和换行**
```java
package demo01.writer;

import java.io.FileWriter;
import java.io.IOException;

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
输出结果：
南京
机电学院
大学
```
**FileReader和FileWriter类完成文本文件复制**
```java
package demo01.writer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author HL Zhou
 * @Date 2021/5/28 9:21
 */
public class FWReaderWriter {
    public static void main(String[] args) throws IOException {
        //使用文件名称创建输入流对象和输出流对象
        FileReader fr = new FileReader("FW.txt");
        FileWriter fw = new FileWriter("a.txt");
        //文本文件复制，一次一个字符
        copyMethod1(fr, fw);
        //文本文件复制，一次一个字符数组
        copyMethod2(fr, fw);
        fr.close();
        fw.close();


    }
    //文本文件复制，一次一个字符
    public static void copyMethod1(FileReader fr, FileWriter fw) throws IOException {
        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }
        fw.close();
    }

    //文本文件复制，一次一个字符数组
    public static void copyMethod2(FileReader fr, FileWriter fw) throws IOException {
        int len = 0;
        //创建一个数组
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            fw.write(chars,0,len);
        }
        fw.close();
    }
}
```
>**字符流，只能操作文本文件，不能操作图片，视频等非文本文件。当我们单纯读或者写文本文件时 使用字符流 其他情况使用字节流**

**IO异常处理**
我们在学习的过程中可能习惯把异常抛出，而实际开发中并不能这样处理，
建议使用`try...catch...finally` 代码块，处理异常部分，格式代码如下：
```java
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
```