package demo01;

/**
 * @Author HL Zhou
 * @Date 2021/5/15 20:41
 */
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
