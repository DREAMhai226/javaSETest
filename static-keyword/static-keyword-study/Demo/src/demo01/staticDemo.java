package demo01;

/**
 * @Author HL Zhou
 * @Date 2021/5/15 11:50
 */
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
