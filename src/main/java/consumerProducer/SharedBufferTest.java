package consumerProducer;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SharedBufferTest {


    public static void main(String[] args) throws InterruptedException {

        // Create a new thread pool with two threads.
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Create an UnsychronizedBuffer to store integers.
        Buffer sharedLocation = new UnsynchronizedBuffer();

        System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
        System.out.println("------\t\t-----\t---------------\t---------------%n%n");

        // Execute the producer and consumer threads, giving each thread access to the shared buffer.
        executorService.execute(new Producer(sharedLocation));
        executorService.execute(new Consumer(sharedLocation));

        // Wait for all threads to finish.
        executorService.shutdown();     // Terminate application when all threads are finished.
        executorService.awaitTermination(1, TimeUnit.NANOSECONDS);

    } // end of main()


} // end of SharedBufferTest{}
