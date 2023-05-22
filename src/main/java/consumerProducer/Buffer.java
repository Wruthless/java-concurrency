package consumerProducer;


public interface Buffer {


    // Place an int value into the Buffer.
    public void blockingPut(int value) throws InterruptedException;

    // Obtain an int value from the Buffer.
    public int blockingGet() throws InterruptedException;


} // end Buffer{}
