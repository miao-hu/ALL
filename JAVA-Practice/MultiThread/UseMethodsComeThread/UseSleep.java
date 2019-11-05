/*
休眠当前线程4秒
线程调度是不可控的，所以这个方法只能保证休眠时间是大于等于休眠时间的
 */
public class UseSleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis());
        Thread.sleep(4*1000);
        System.out.println(System.currentTimeMillis());
    }
    /*
            1572770838664
            1572770842675
     */
}
