package charpter5;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * Exchange使用 通过控制 缓冲区，实现生产者消费者数据共享；
 * 协调与互斥原则中， 这里采用缓冲区实现数据协调
 * @author qianzhaoliang
 * @since 2018/12/25
 */
public class Demo5 {

    public static void main(String[] args) {
        String[] cake1 = new String[3];
        String[] cake2 = new String[3];
        Exchanger<String[]> exchanger = new Exchanger<>();
        new Producer(exchanger, cake2).start();
        new Consumer(exchanger, cake1).start();
    }
}

class Consumer extends Thread {
    private Exchanger<String[]> exchanger;
    private String[] cakes;
    private Random random;
    public Consumer(Exchanger exchanger, String[] cakes) {
        super("Consumer");
        this.exchanger = exchanger;
        this.cakes = cakes;
        random = new Random(1L);
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println(String.format("thread %s start to consume", Thread.currentThread().getName()));
                cakes = exchanger.exchange(cakes);
                for(String v : cakes) {
                    System.out.println(String.format("take %s", v));
                    //Thread.sleep(random.nextInt(1000));
                }
            }
        } catch (InterruptedException ire) {

        }

    }
}

class Producer extends Thread {
    private Exchanger<String[]> exchanger;
    private String[] cakes;
    private Random random ;

    public Producer(Exchanger exchanger, String[] cakes) {
        super("Producer");
        this.exchanger = exchanger;
        this.cakes = cakes;
        random = new Random(2L);
    }

    @Override
    public void run() {
        try {
            while(true) {
                System.out.println(String.format("Thread %s start to produce", Thread.currentThread().getName()));
                for (int pos =0; pos < 3; pos++) {
                    cakes[pos] = "CAKE"+ (pos+1);
                    System.out.println(String.format("put %s", cakes[pos]));
                    //Thread.sleep(random.nextInt(1000));
                }
                cakes = exchanger.exchange(cakes);
            }
        }
        catch (InterruptedException ire) {

        }

    }
}
