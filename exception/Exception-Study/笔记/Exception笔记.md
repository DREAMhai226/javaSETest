# 1，异常
## 1.1 异常概念
**异常**：程序不能正常运行，JVM非正常停止。
在Java等面向对象的编程语言中，异常本身是一个类，产生异常就是创建异常对象并抛出了一个异常对象。Java处理异常的方式是中断处理
>异常指的并不是语法错误，语法错了编译不能通过，不会产生字节码文件，根本不能运行

## 1.2 异常体系
异常的根类：`java.lang.Throwable`其下有两个子类：`java.lang.Error`和`java.lang.Exception`。异常一般指`java.lang.Exception`
**Throwable中的常用方法：**