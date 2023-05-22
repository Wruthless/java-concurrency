import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExecutor {

    public static void main(String[] args) {

        // create and name each runnable
        PrintTask task1 = new PrintTask("task1");
        PrintTask task2 = new PrintTask("task2");
        PrintTask task3 = new PrintTask("task3");

        System.out.println("Starting Executor");

        // create ExecutorService to manage threads
        // Used to launch concurrent tasks.
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Start the three PrintTasks
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.execute(task3);

        // shut down ExecutorService
        executorService.shutdown();

        System.out.printf("Tasks started, main ends. %n%n");
    }

}
