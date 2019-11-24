import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;   //BolckingQueue是一个接口
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
/*
使用JAVA自带的阻塞队列实现生产者消费者模型
只能用队列的put() 和take()方法

放入消息:51
取出消息：51
放入消息:8
取出消息：8
取出消息：39
放入消息:39
........
 */
public class UseBlockingQueue {
    //Java自带的阻塞队列
    private static BlockingQueue<String> queue=new ArrayBlockingQueue<String>(1);
    //new PriorityBlockingQueue<>(1);
    //new LinkedBlockingDeque<>(1);
    //new ArrayBlockingQueue<>(1);
    private static class Producer extends Thread {
        @Override
        public void run() {
            Random random = new Random(20191117);
            while (true) {
                try {
                    int message = random.nextInt(100);
                    queue.put(String.valueOf(message));
                    System.out.println("放入消息:" + message);
                    Thread.sleep(random.nextInt(3) * 100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private static class Customer extends Thread {
        @Override
        public void run() {
            Random random=new Random();
            while (true) {
                try {
                    System.out.println("取出消息：" + queue.take());
                    Thread.sleep(random.nextInt(3)*100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Producer();
        Thread t2=new Customer();
        t1.start();
        t2.start();
    }
}
