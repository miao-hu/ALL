package pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// 固定线程池，一开始是就申请好线程
public class ThreadPoolV2 {
    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
    private Thread[] workers = new Thread[5];

    ThreadPoolV2() {
        for (int i = 0; i < 5; i++) {
            workers[i] = new Worker(workQueue);
            workers[i].start();
        }
    }

    public void execute(Runnable cmd) throws InterruptedException {
        workQueue.put(cmd);
    }

    public void stop() {
        for (int i = 0; i < 5; i++) {
            workers[i].interrupt();
        }
    }

    private static class Worker extends Thread {
        private BlockingQueue<Runnable> workQueue;

        Worker(BlockingQueue<Runnable> queue) {
            workQueue = queue;
        }

        @Override
        public void run() {
            while (!isInterrupted()) {
                try {
                    Runnable cmd = workQueue.take();
                    cmd.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolV2 pool = new ThreadPoolV2();
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第一个事情");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第二个事情");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第三 个事情");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第四个事情");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第五个事情");
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("第六个时期");
            }
        });
        pool.stop();  //中断所有线程
    }
}
