package timer;
/*
另一个人
该起床了
 */
import java.util.concurrent.PriorityBlockingQueue;

public class MyTimer {
    //阻塞队列中放的是我的任务
    PriorityBlockingQueue<MyTimerTask> queue = new PriorityBlockingQueue<>();
    //工人线程
    Worker worker;


    MyTimer() {
        worker = new Worker(queue);
        worker.start();  //线程启动
    }

    private static class Worker extends Thread {
        PriorityBlockingQueue<MyTimerTask> queue;

        Worker(PriorityBlockingQueue<MyTimerTask> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    MyTimerTask task = queue.take();   //取任务
                    long current = System.currentTimeMillis();
                    if (task.delay <= current) {
                        task.target.run();
                    } else {
                        queue.put(task);  //时间没到，把取出来的任务放回队列中去
                        Thread.sleep(task.delay - current);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    void execute(Runnable target, long delay) {
        queue.put(new MyTimerTask(target, delay));
    }

    public static void main(String[] args) {
        MyTimer timer = new MyTimer();  //创建一个我的定时器
        timer.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("该起床了");
            }
        }, 2000);
        System.out.println("另一个人");
    }
}
