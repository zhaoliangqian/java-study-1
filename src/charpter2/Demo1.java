package charpter2;

/**
 * final修饰 静态方法
 * @author qianzhaoliang
 * @since 2018/12/19
 */
public class Demo1 {
}

class Parent {
    public static void method1() {
        System.out.println("method1");
    }
    public static final void method2() {
        System.out.println("method2");
    }
}
class Child extends Parent {
    public static void method1() {
        System.out.println("child: method1");
    }
    //编译报错 can't override final method
/*    public static final void method2() {

    }*/
}