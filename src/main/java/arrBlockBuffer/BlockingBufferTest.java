package arrBlockBuffer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class BlockingBufferTest {


    public static void main(String[] args) throws InterruptedException {

        // Create a new thread pool with two threads using newCachedThreadPool()
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Create a BlockingBuffer to store integers.
        Buffer sharedLocation = new BlockingBuffer();

        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

    }

}
