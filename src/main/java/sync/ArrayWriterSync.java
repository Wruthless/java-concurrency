package sync;

// Implements Runnable so that is specifies a task performed concurrently.
public class ArrayWriterSync implements Runnable{

    private final SimpleArraySync sharedSimpleArraySync;
    private final int startValue;

    public ArrayWriterSync(int value, SimpleArraySync array) {
        startValue = value;
        sharedSimpleArraySync = array;
    }

    public void run() {
        for (int i = startValue; i < startValue + 3; i++) {
            sharedSimpleArraySync.add(i);
        }
    }
}
