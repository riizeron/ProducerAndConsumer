package producerconsumer.models.threads;

import producerconsumer.models.Data;

public class Consumer implements Runnable {

    private final Data data;

    public Consumer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            Integer elem;
            while (true) {
                consume(data.get());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void consume(int elem) {
        System.out.println(String.format("Consumer get: %d.", elem));
    }
}
