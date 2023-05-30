package usingSync;


public interface Buffer {


    // Place int value into the buffer.
    public void blockingPut(int value) throws InterruptedException;

    // Obtain int value from the buffer.
    public int blockingGet( ) throws InterruptedException;


} // end of Buffer{}
