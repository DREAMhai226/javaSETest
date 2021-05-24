# 1，static存在的意义
* 1，创建于独立于对象具体对象的**域变量**或者**方法**，**以致于即使没有创建对象，
也能使用属性或者调用方法！
* 2，**用来形成静态代码块**来优化程序性能
***
# 2，static的特点
* 1，被static修饰的变量或者方法**独立于**该类的任何对象，**被类的实例对象所共享**。
* 2，在该类被第一次加载的时候，就会去加载被static修饰的部分，而且只在类第一次使用时加载并进行初始化，注意这是第一次用就要初始化，后面根据需要是可以再次赋值的。
* 3、static变量值在类加载的时候分配空间，以后创建类对象的时候不会重新分配。赋值的话，是可以任意赋值的！
* 4、被static修饰的变量或者方法是优先于对象存在的，也就是说当一个类加载完毕之后，即便没有创建对象，也可以去访问。
***
# 3，static应用场景
因为static是被类的实例对象所共享，因此如果某个成员变量是被所有对象所共享的，那么这个成员变量就应该定义为静态变量。
使用场景：
> 1,修饰成员变量
> 2,修饰成员方法
> 3,静态代码块
> 4,修饰类(只能修饰内部类即静态内部类)
> 5,静态导包
***
# 4，静态变量和实例变量的概念
* 静态变量：static修饰的成员变量叫静态变量(也叫类变量)，静态变量属于这个类，而不属于对象  
* 实例变量：没有被static修饰的成员变量叫做实例变量，实例变量是属于这个**类的实例对象**
注意：**static不允许用来修饰局部变量**
***
# 5，静态变量和实例变量和区别
* 静态变量：由于不属于任何实例对象，属于类的，所以内存中只会有一份，在类加载的过程中，JVM只为静态变量分配一次存储空间。
* 实例变量：每次创建对象，都会为每个对象分配成员变量内存空间。实例变量是属于实例对象的，在内存中创建几次对象。就有几份成员变量。
***
# 6，访问静态变量和实例变量的两种方式
```java
package demo01;

public class staticDemo {
    static int a = 100;

    public static void main(String[] args) {
        new staticDemo().method();
    }
    private void method(){
        int a = 123;
        //this指的是 staticDemo 这个类，所以a就指静态变量
        System.out.println(this.a);
    }
}
```
访问静态变量和静态方法的两种方法：
静态变量：
>类名。静态变量  
>对象。静态变量(不推荐)

静态方法:
>类名。静态方法  
>对象。静态方法(不推荐) 
***
# 7，staic静态方法
static关键字修饰的方法是静态方法，不属于任何实例对象，this指的是当前对象，因为static静态方法不属于任何对象，所以就谈不上this了。
**构造方法不是静态方法**
***
# 8，static静态代码块
序代码继承关系为 BaseThree——> BaseTwo——> BaseOne
BaseOne类
```java
package demo01;

import javax.swing.*;
import java.net.SocketTimeoutException;

public class BaseOne {
    public BaseOne() {
        System.out.println("BaseOne构造器！");
    }
    {
        System.out.println("BaseOne初始化块！");
        System.out.println();
    }
    static {
        System.out.println("BaseOne静态初始化块！");
    }
}
```
BaseTwo类
```java
package demo01;

public class BaseTwo extends BaseOne{
    public BaseTwo() {
        System.out.println("BaseTwo构造器！");
    }
    {
        System.out.println("BaseTwo初始化块！");
    }
    static {
        System.out.println("BaseTwo静态初始化块！");
    }
}
```
BaseThree类
```java
package demo01;

public class BaseThree extends BaseTwo{
    public BaseThree() {
        System.out.println("BaseThree构造器！");
    }
    {
        System.out.println("BaseThree初始化块！");
    }
    static {
        System.out.println("BaseThree静态初始化块！");
    }
}
```
测试类
```java
package demo01;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Demo02 {
    public static void main(String[] args) {
        BaseThree baseThree1 = new BaseThree();
        System.out.println("==================");
        BaseThree baseThree2 = new BaseThree();
    }
}
```
运行结果
```java
BaseOne静态初始化块！
BaseTwo静态初始化块！
BaseThree静态初始化块！
BaseOne初始化块！

BaseOne构造器！
BaseTwo初始化块！
BaseTwo构造器！
BaseThree初始化块！
BaseThree构造器！
==================
BaseOne初始化块！

BaseOne构造器！
BaseTwo初始化块！
BaseTwo构造器！
BaseThree初始化块！
BaseThree构造器！
```
结果分析：
>static代码块只执行一次
***
# 9，static静态变量和普通变量的区别
static变量也称作静态变量，静态变量和非静态变量的区别是：静态变量被所有的对象所共享，
在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。
还有一点就是static成员变量的初始化顺序按照定义的顺序进行初始化。
***
# 10，静态内部类
* 1，它的创建不需要依赖外围类的创建
* 2，不使用任何外围类的非static成员变量和方法
代码举例(静态内部类实现单例模式)
```java
package demo01;

public class Singleton {
    // 声明为 private 避免调用默认构造方法创建对象
    private Singleton() {
    }
    // 声明为 private 表明静态内部该类只能在该 Singleton 类中被访问
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getUniqueInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```
当`singleton`类加载时，静态内部类`SingletonHolder`没有被加载进内存。
只有当调用`getUniqueInstance()`方法从而触发`SingletonHolder.INSTANCE`时`SingletonHolder` 才会被加载，此时初始化 `INSTANCE` 实例，并且 JVM 能确保 `INSTANCE` 只被实例化一次。
这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
***
# 11，静态导包
静态导包格式：`import static`
这两个关键字连用可以指定导入某个类中的指定静态资源，并且不需要使用类名调用类中静态成员，可以直接使用类中静态成员变量和成员方法
```java
//  Math. --- 将Math中的所有静态资源导入，这时候可以直接使用里面的静态方法，而不用通过类名进行调用
//  如果只想导入单一某个静态方法，只需要将换成对应的方法名即可
package demo01;

//换成import static java.lang.Math.max;

import static java.lang.Math.max;

public class Demo03 {
    public static void main(String[] args) {
        int max = max(1, 2);
        System.out.println(max);
    }
}
```
静态导包在书写代码的时候确实能省一点代码，可以直接调用里面的静态成员，但是会影响代码可读性，所以开发中一般情况下不建议这么使用。
***
# 12，static注意事项
* 1，静态只能访问静态
* 2，非静态既可以访问非静态的，也可以访问静态的