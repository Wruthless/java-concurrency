package sync;

import java.security.SecureRandom;
import java.util.Arrays;


public class SimpleArraySync {

    private static final SecureRandom generator = new SecureRandom();
    // The shared array.
    private final int[] array;
    // Shared index of the next element to write.
    private int writeIndex = 0;

    public SimpleArraySync(int size) {
        array = new int[size];
    }

    public synchronized void add(int value) {
        int position = writeIndex;

        try {
            Thread.sleep(generator.nextInt(500));
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // Put value in the appropriate element.
        array[position] = value;
        System.out.printf("%s write %2d to element %d.%n",
                Thread.currentThread().getName(), value, position);

        // Increment index of the element to be written.
        ++writeIndex;
        System.out.printf("Next write index: %d%n", writeIndex);
    }

    public String toString() {
        return Arrays.toString(array);
    }
}
