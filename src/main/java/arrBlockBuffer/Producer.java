package arrBlockBuffer;


import java.security.SecureRandom;


public class Producer implements Runnable {


    private static final SecureRandom generator = new SecureRandom( );
    private final Buffer sharedLocation;

    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }

    public void run( ) {

        int sum = 0;

        for (int count = 1; count <= 10; count++) {
            // Sleep 0 to 3 seconds, then place a new value in the buffer.
            try {
                Thread.sleep(generator.nextInt(3000));
                sharedLocation.blockingPut(count);
                sum += count;
            } catch (InterruptedException e) {
                Thread.currentThread( ).interrupt( );
            }
        }

        System.out.printf("Producer done producing%nTerminating producer%n");

    }


} // end class Producer{}
