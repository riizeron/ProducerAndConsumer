package producerconsumer.models;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Data {
    private final BlockingQueue<Integer> queue;

    public Data(int size) {
        queue = new ArrayBlockingQueue<>(size);
    }

    public void put(int elem) throws InterruptedException {
        queue.put(elem);
    }

    public Integer get() throws InterruptedException {
        return queue.take();
    }
}
