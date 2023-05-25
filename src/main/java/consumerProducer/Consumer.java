package consumerProducer;


import java.security.SecureRandom;


/// Runnable allows concurrent access to the shared buffer.
public class Consumer implements Runnable {


    private static final SecureRandom generator = new SecureRandom();
    private final Buffer sharedLocation;    // The reference to the shared buffer.

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    @Override
    public void run() {
        int sum = 0;

        for (int i = 1; i <= 10; i++) {
            // Sleep 0 to 3 seconds, read value from buffer and add it to sum.
            try {
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.blockingGet();
                System.out.printf("\t\t\t%2d%n", sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("%n%s %d%n%s%n", "Consumer read values totaling", sum, "Terminating Consumer");
    } // End of run().


} // End of class Consumer.
