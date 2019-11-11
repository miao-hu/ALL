/*
打印结果是  张三：我正跑着呢   答应的比   李四：我正跑着呢  打印的少
原因：
    1. yield() 只是让出 CPU，并不会改变自己的状态。
    也就上面所叙述，我从柜台前站起，又重新去排队去了，排到就绪队列，等待系统调度
    2. 因为张三总是无私的让出座位，李四并不让座位，所以会导致李四的打印更多。
 */
public class UseYield {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": 我正跑着呢");
                Thread.yield();  //yield() 大公无私，让出 CPU
            }
        }, "张三");
        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": 我正跑着呢");
            }
        }, "李四");
        t1.start();
        //t1.join();   //有这句话一直打印  张三：我正跑着呢
        t2.start();
    }
}
