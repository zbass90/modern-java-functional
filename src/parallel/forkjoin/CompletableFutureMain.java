package parallel.forkjoin;

import static util.MyLogger.*;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureMain {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> log("Fork/Join")); // Fork/Join 공용 풀

        ExecutorService es = Executors.newFixedThreadPool(100);
        CompletableFuture.runAsync(() -> log("Custom Pool"), es); // 별도의 풀
        Thread.sleep(100);
        es.close();
    }
}