package arrBlockBuffer;


import java.util.concurrent.ArrayBlockingQueue;


public class BlockingBuffer implements Buffer {


    private final ArrayBlockingQueue<Integer> buffer;

    /**
     * This constructor initializes a buffer instance variable with a
     * new ArrayBlockingQueue of Integers with a size of 1.
     */
    public BlockingBuffer() {
        this.buffer = new ArrayBlockingQueue<Integer>(1);
    }

    /**
     * Place the value into the ArrayBlockingQueue. This is a synchronized operation.
     * It will only allow the put operation to work if the ArrayBlockingQueue is empty,
     * since we only have a one element queue.
     */
    @Override
    public void blockingPut(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value, "Buffer calls occupied ", buffer.size( ));
    }


    /**
     * Take the value from the ArrayBlockingQueue. This is a synchronized operation.
     * buffer.take() will block until a value is available. Only once a producer has
     * placed a value into the ArrayBlockingQueue, will it return that value.
     * @return the value from the ArrayBlockingQueue
     * @throws InterruptedException
     */
    @Override
    public int blockingGet() throws InterruptedException {
        int readValue = buffer.take( );
        System.out.printf("%s%2d\t%s%d%n", "Consumer reads ", readValue, "Buffer calls occupied ", buffer.size( ));

        return readValue;
    }


}
