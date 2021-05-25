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
* 1、<font color=#FF0000>指定目录必须存在</font>
* 2、<font color=#FF0000>指定必须是目录，否则容易引发数组为null，出现NullPointerException空指针异常</font>

## 2.5 递归遍历

# 3、IO流

## 3.1 IO的概念

## 3.2 IO的分类

## 3.3 IO的分流说明
