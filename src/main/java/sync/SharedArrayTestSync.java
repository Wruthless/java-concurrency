package sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class SharedArrayTestSync {

    public static void main(String[] args) {

        // Shared object constructor
        SimpleArraySync sharedSimpleArray = new SimpleArraySync(6);

        // Two tasks objects to shared object.
        ArrayWriterSync writer1 = new ArrayWriterSync(1, sharedSimpleArray);
        ArrayWriterSync writer2 = new ArrayWriterSync(11, sharedSimpleArray);

        // Execute the task with an ExecutorService.
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(writer1);
        executorService.execute(writer2);

        executorService.shutdown();

        try {
            // wait 1 minute for both writers to finish executing
            boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.MINUTES);

            if (tasksEnded) {
                System.out.printf("%nContents of SimpleArray:%n");
                System.out.println(sharedSimpleArray);
            } else {
                System.out.println("Timed out while waiting for tasks to finish.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
