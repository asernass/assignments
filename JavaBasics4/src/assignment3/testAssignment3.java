package assignment3;

import java.util.ArrayList;
import java.util.List;

public class testAssignment3 {
    public static void main(String[] args) {
        List<Integer> buf = new ArrayList<>();
        final Producer pro = new Producer(buf, 10);
        final Consumer consumer = new Consumer(buf);

        Thread p1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    pro.produce();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        Thread c1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    consumer.consume();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        p1.start();
        c1.start();
    }
}
