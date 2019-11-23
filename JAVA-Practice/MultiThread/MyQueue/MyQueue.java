import java.util.Random;

public class MyQueue {
    private int[] array=new int[2];
    private int size=0;
    private int front=0;
    private int rear=0;

    private static MyQueue queue=new MyQueue();

    private static class Producer extends Thread{
        @Override
        public void run() {
            Random random=new Random();
            while(true){
                try{
                    int message=random.nextInt(100);
                    queue.put(message);
                    System.out.println("放入消息:"+message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private synchronized  void put(int message) throws InterruptedException {
        while(size==array.length){
            wait();
        }
        array[rear]=message;
        rear=(rear+1)%array.length;
        size++;
        notifyAll();
    }

    private synchronized  int take() throws InterruptedException {
        while(size==0){
            wait();
        }
        int message=array[front];
        front=(front+1)%array.length;
        size--;
        notifyAll();
        return message;
    }

    private static class Customer extends Thread{
        @Override
        public void run() {
            while(true){
                try{
                    System.out.println("取出消息："+queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Producer();
        Thread t2=new Producer();
        Thread t3=new Producer();

        Thread t4=new Customer();
        Thread t5=new Customer();
        Thread t6=new Customer();
        Thread t7=new Customer();
        Thread t8=new Customer();
        Thread t9=new Customer();
        Thread t10=new Customer();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
