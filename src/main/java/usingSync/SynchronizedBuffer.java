package usingSync;


public class SynchronizedBuffer implements Buffer {


    // Shared by producer and consumer threads.
    private int buffer = -1; // -1 indicates buffer is empty.

    // Boolean variable to help test for conditions in which the
    // producer is allowed to write and the consumer is allowed to read.
    private boolean occupied = false;


    // Put value into buffer. blockingPut() is a synchronized method.
    // Only one thread at a time can access the synchronized method
    // of a particular object.
    public synchronized void blockingPut(int value) throws InterruptedException {

        // If there are no empty slots in buffer, put thread in waiting state.
        // Controls order of thread execution.
        while (occupied) {
            // Output thread and buffer information, then wait.
            System.out.println("Producer tries to write.");
            displayState("Buffer is full. Producer waits.");
            wait( );
        }
        // Set new buffer value.
        buffer = value;

        // Indicate the producer cannot store another value
        // until the consumer retrievers the current value.
        occupied = true;

        displayState("Producer writes " + buffer);

        notifyAll( );

    } // end of blockingPut() method.

    // Get value from buffer. blockingGet() is a synchronized method.
    public synchronized int blockingGet( ) throws InterruptedException {

        while (!occupied) {
            // Output thread and buffer information, then wait.
            System.out.println("Consumer tries to read.");
            displayState("Buffer is empty. Consumer waits.");
            wait( );
        }

        // Consumer has retrieved the value from buffer.
        occupied = false;
        displayState("Consumer reads " + buffer);

        // Tell waiting thread that the buffer is empty.
        notifyAll( );

        return buffer;

    } // end of blockingGet() method; releases lock on SynchronizedBuffer.

    private synchronized void displayState(String operation) {
        System.out.printf("%-40s%d\t\t%b%n%n", operation, buffer, occupied);
    }


} // end of class SynchronizedBuffer{}
