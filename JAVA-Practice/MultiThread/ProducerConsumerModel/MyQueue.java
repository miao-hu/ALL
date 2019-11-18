//生产者，消费者模型
public class MyQueue {
    private int[] array=new int[10];
    private int size=0;
    private int front=0;
    private int rear=0;

    public  synchronized void put(int message) throws InterruptedException {
        if(size==array.length){
            wait();
        }
        array[rear]=message;
        rear=(rear+1)%array.length;
        size++;
        notifyAll();
    }

    public synchronized int take() throws InterruptedException {
        if(size==0){
            wait();
        }
        int message=array[front];
        front=(front+1)%array.length;
        size--;
        // 消费者必须唤醒一个生产者，但如果只是调用 notify
        // 不保证唤醒的是生产者,若消费者有多个，可能唤醒的还是消费者
        notifyAll();
        return message;
    }

    public int take2() throws InterruptedException {
        if(size==0){
            do{
                synchronized (this){
                    if(size==0){
                        this.wait();
                        //这里线程进入等待集，要是唤醒它的是消费者怎么办？
                    }
                }

            }while(size==0);
        }
        int message;
        synchronized (this) {
            message = array[front];
            front = (front + 1) % array.length;
            size--;
            notifyAll(); //必须使用在代码块中
        }
        return message;
    }
    private static MyQueue queue=new MyQueue();
    private static class Producer extends Thread{
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                try {
                    queue.put(i);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
        }
    }
    private static class Customer extends Thread{
        @Override
        public void run() {
            while(true){
                int message=0;
                try {
                    message=queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(message);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Producer();
        Thread t2=new Producer();
        Thread t3=new Customer();
        t1.start();
        t2.start();
        t3.start();
    }
}
