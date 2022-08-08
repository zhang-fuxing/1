package threadimpl.pool;

import java.util.concurrent.*;

/**
 * @author zfx
 * @date 2022-07-25 18:57
 */
public class ThreadPoolStudy {
    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newFixedThreadPool(2);
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 自定义线程池
    }
}
