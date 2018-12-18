package charpter5;

/**
 * wait方法的中断
 * @author qianzhaoliang
 * @since 2018/12/13
 */
public class Demo2 {

    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA2 threadA2 = new ThreadA2(lock);
        threadA2.start();
        threadA2.interrupt();
    }
}

class ThreadA2 extends Thread {

    private Object lock;
    public ThreadA2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                lock.wait(10000);
            }
        }
        catch (InterruptedException ire) {
            System.err.println("a is interrupted");
        }
        System.out.println("a is done");
    }
}
