package consumerProducer;


import java.security.SecureRandom;


public class Producer implements Runnable {


    // Produce random sleep times.
    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;

    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    // Store values from  one (1) to ten (10) in the shared buffer.
    @Override
    public void run() {
        // Keeps track of the sum all the values produced and stored in the
        // shared buffer (sharedLocation).
        int sum = 0;

        for (int i = 1; i < 10; i++) {
            try {

                Thread.sleep(generator.nextInt(3000));  // Sleep for a random amount of time.
                sharedLocation.blockingPut(i);                // Put a value in the shared buffer.
                sum += i;
                System.out.printf("\t%2d\n", sum);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.print("Producer finished.\nTerminating Producer.\n");
    } // end of run()


} // end of Producer{}
