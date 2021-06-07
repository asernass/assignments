package assignment3;

import java.util.List;

public class Consumer {
    List<Integer> buffer;

    public Consumer(List<Integer> buffer) {
        this.buffer = buffer;
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (buffer) {
                while (buffer.isEmpty()) {
                    buffer.wait();
                }

                int val = buffer.remove(0);
                System.out.println("Consumer consumed " + val);
                buffer.notifyAll();
                Thread.sleep(1000);
            }
        }
    }
}
