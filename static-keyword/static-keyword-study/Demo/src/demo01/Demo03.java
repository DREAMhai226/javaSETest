//  Math. --- 将Math中的所有静态资源导入，这时候可以直接使用里面的静态方法，而不用通过类名进行调用
//  如果只想导入单一某个静态方法，只需要将换成对应的方法名即可
package demo01;

//换成import static java.lang.Math.max;

import static java.lang.Math.max;

/**
 * @Author HL Zhou
 * @Date 2021/5/15 21:09
 */
public class Demo03 {
    public static void main(String[] args) {
        int max = max(1, 2);
        System.out.println(max);
    }
}
