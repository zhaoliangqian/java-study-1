package charpter10;

/**
 * @author qianzhaoliang
 * @since 2019/01/04
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(10000);
            }
            catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("finally");
            }
        });
        t.start();
        t.interrupt();
        System.out.println("thread is interrupted");

    }
}