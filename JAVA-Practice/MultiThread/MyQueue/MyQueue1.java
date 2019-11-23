/*
因为申请锁和抢到锁之间要持续时间很久，理解为10年
可能你抢到锁的时候size的值已经被改变  所以这个MyQueue不安全
还需改进
 */
public class MyQueue1 {
    private int[] array=new int[2];
    private volatile int size=0;//要保持可见性
    private int front=0;
    private int rear=0;

    private Object full=new Object();   //两个等待集
    private Object empty=new Object();

    //锁的细粒度
    private  void put(int message) throws InterruptedException {
        while(size==array.length){
            synchronized (full){
                full.wait(); //放入满了的等待集
            }
        }
        synchronized (this) {  //需要很长时间
            array[rear] = message;
            rear = (rear + 1) % array.length;
            size++;
        }
        synchronized (empty) {
            empty.notify();
        }
    }

    private  int take() throws InterruptedException {
        while(size==0){
            synchronized (empty) {
                empty.wait();
            }
        }
        int message;
        synchronized (this) {
            message = array[front];
            front = (front + 1) % array.length;
            size--;
        }
        synchronized (full){
            full.notify();
        }
        return message;
    }
}
