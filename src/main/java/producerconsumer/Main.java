package producerconsumer;

import producerconsumer.models.Data;
import producerconsumer.models.threads.Consumer;
import producerconsumer.models.threads.Producer;

import java.util.concurrent.*;

public class Main {

    static ExecutorService pool = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        try {
            Data data = new Data(5);

            Future future = pool.submit(new Consumer(data));

            pool.execute(new Producer(data));
            pool.execute(new Producer(data));
            pool.execute(new Producer(data));
            pool.execute(new Producer(data));
            pool.execute(new Producer(data));
            pool.execute(new Producer(data));

            future.get();
            pool.shutdown();
            if (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
                pool.shutdownNow();
            }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            pool.shutdownNow();
        }
    }
}
