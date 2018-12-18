package charpter5;

/**
 * sleep 中断
 * @author qianzhaoliang
 * @since 2018/12/13
 */
public class Demo1 {
    public static void main(String[] args) {
        A a= new A();
        a.start();
        new B(a).start();
    }
}

class A extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException ire) {
            //Thread.interrupted();
            System.out.println("a is interrupted");
        }

    }
}
class B extends Thread {

    private A threadA;
    public B(A a) {
        this.threadA = a;
    }
    @Override
    public void run() {
        threadA.interrupt();
    }
}