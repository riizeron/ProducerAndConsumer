package producerconsumer.models.threads;

import producerconsumer.models.Data;

import java.util.Random;

public class Producer implements Runnable {
    private final Data data;
    Random rnd = new Random();

    public Producer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            int elem;
            while (true) {
                data.put(produce());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private int produce() {
        int elem = rnd.nextInt(100, 500);
        System.out.println(String.format("Produced: %d.", elem));
        return elem;
    }
}
