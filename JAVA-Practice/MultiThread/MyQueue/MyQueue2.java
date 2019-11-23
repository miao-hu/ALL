public class MyQueue2 {
    private int[] array=new int[2];
    private volatile int size=0;//要保持可见性
    private int front=0;
    private int rear=0;

    private Object full=new Object();   //两个等待集
    private Object empty=new Object();

    //锁的细粒度
    private  void put(int message) throws InterruptedException {
        //采用do  while  先保证执行一次
        do {
            while (size == array.length) {
                synchronized (full) {
                    full.wait(); //放入满了的等待集
                }
            }//按理来说退出循环已经size<array.length了
            //但是申请锁和成功加锁之间有十年的时间
            synchronized (this) {  //需要很长时间
                if(size==array.length){  //还要判断size的值是否和数组长度已经一样了
                    continue;
                }
                array[rear] = message;
                rear = (rear + 1) % array.length;
                size++;
            }
            synchronized (empty) {
                empty.notify();
            }
            return;
        }while(true);
    }

    private  int take() throws InterruptedException {
        do {
            while (size == 0) {
                synchronized (empty) {
                    empty.wait();
                }
            }
            int message;
            synchronized (this) {  //需要很长时间
                if(size==0){
                    continue;
                }
                message = array[front];
                front = (front + 1) % array.length;
                size--;
            }
            synchronized (full) {
                full.notify();
            }
            return message;
        }while(true);
    }
}
