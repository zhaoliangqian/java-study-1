package charpter5;

/**
 * join and interrupt
 * @author qianzhaoliang
 * @since 2018/12/13
 */
public class Demo3 {
    public static void main(String[] args) {
        A3 a = new A3();
        a.start();
        B3 b = new B3(a);
        b.start();
        a.interrupt();
    }
}

class A3 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException ire) {
            System.err.println("a is interrupted");
        }
    }
}
class B3 extends Thread {
    private A3 a;
    public B3(A3 a) {
        this.a = a;
    }

    @Override
    public void run() {
        try {
            a.join();
        }
        catch (InterruptedException ire) {
            System.err.println("b is interrupted");
        }
        System.out.println("b is done");
    }
}