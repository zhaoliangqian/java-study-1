package charpter2;

import java.util.List;

/**
 * 多线程环境下， 使用迭代器遍历list，需要进行同步
 * @author qianzhaoliang
 * @since 2018/12/19
 */
public class Demo2 {


}
class ReadThread extends Thread {
    private List<Integer> list;

    public ReadThread(List<Integer> list) {
        this.list = list;
    }
    @Override
    public void run() {
        synchronized (list) {
            /**
             * 隐式迭代器
             */
            for (Integer item : list) {
                System.out.println(item);
            }
        }

        //隐式迭代器
        synchronized (list) {
            System.out.println(list);
        }

    }
}