package assignment3;

import java.util.List;

public class Producer {
    private List<Integer> buffer;
    private Integer MaxSize;

    public Producer(List<Integer> buffer, Integer size) {
        this.buffer = buffer;
        this.MaxSize = size;
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (buffer) {
                while (buffer.size() == MaxSize) {
                    buffer.wait();
                }
                System.out.println("Producer produced " + value);
                buffer.add(value++);
                buffer.notifyAll();
                Thread.sleep(1000);
            }
        }
    }

}
