package consumerProducer;


public class UnsynchronizedBuffer implements Buffer {


    // Shared by the producer and consumer threads.
    private int buffer = -1;

    // Place the value in the buffer.
    public void blockingPut(int value) throws InterruptedException {
        System.out.printf("Producing value \t%2d\n", value);
        buffer = value;
    }

    // Get the value from the buffer.
    public int blockingGet() throws InterruptedException {
        System.out.printf("Consuming value \t%2d\n", buffer);
        return buffer;
    }


} // end of UnsychronizedBuffer {}
