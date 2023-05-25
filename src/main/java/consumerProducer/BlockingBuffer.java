package consumerProducer;


import java.util.concurrent.ArrayBlockingQueue;


public class BlockingBuffer implements Buffer {


    private final ArrayBlockingQueue<Integer> buffer;

    public BlockingBuffer(int size) {
        this.buffer = new ArrayBlockingQueue<>(1);
    }

    // Place value in the buffer.
    @Override
    public void blockingPut(int value) throws InterruptedException {
        buffer.put(value);
        System.out.printf("%s%2d\t%s%d%n", "Producer writes ", value, "Buffer calls occupied", buffer.size());
    }

    @Override
    public int blockingGet() throws InterruptedException {
        return 0;
    }


}
