/*
    计算的COUNT不同。那么耗时不同
    并行模式不一定优于串行模式    因为线程的创建需要消耗资源
    数字越小  串行模式越省时
    数字越大  并行模式越省时
 */
public class ThreadDemo5 {
    private static final long COUNT=10_00000;

    private static class CalcThread extends Thread{
        @Override
        public void run() {
            int n=0;
            for(long i=1;i<=COUNT;i++){
                n++;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        serial();       // 串行
        concurrent();   // 并发
    }

    private static void concurrent() throws InterruptedException {
        long begin=System.nanoTime();
        Thread t1=new CalcThread();
        Thread t2=new CalcThread();
        t1.start();
        t2.start();
        int a=0;
        for(int i=1;i<=COUNT;i++){
            a++;
        }

        t1.join();  //确保进程已经结束
        t2.join();
        long end=System.nanoTime();
        double result=(end-begin)*1.0/1000/1000/1000;
        System.out.printf("并行模式：：：计算从1-10_0000的和共耗时:%f%n",result);
    }

    private static void serial() {
        long begin=System.nanoTime();
        int a=0;
        for(long i=1;i<=COUNT;i++){
            a++;
        }
        int b=0;
        for(long i=1;i<=COUNT;i++){
            b++;
        }
        int c=0;
        for(long i=1;i<=COUNT;i++){
            c++;
        }
        long end=System.nanoTime();
        double result=(end-begin)*1.0/1000/1000/1000;
        System.out.printf("串行模式：：：计算从1-10_0000的和共耗时:%f%n",result);
    }
}
