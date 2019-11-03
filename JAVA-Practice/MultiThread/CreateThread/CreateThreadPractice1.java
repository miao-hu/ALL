public class CreateThreadPractice1 {
    private static class P1 extends Thread{
        private int n=10_0000;

        @Override
        public void run() {
            long sum=0;
            for(int i=1;i<=n;i++){
                sum+=i;
            }
            System.out.println("P1:1+2+3+...+n="+sum);
        }
    }

    private static class P2 extends Thread{
        private int n=10_0000;

        @Override
        public void run() {
            long sum=0;
            for(int i=1;i<=n;i++){
                sum+=(i*i);
            }
            System.out.println("P2:1+4+9+...+n="+sum);
        }
    }

    private static class P3 extends Thread{
        private int n=10_0000;

        @Override
        public void run() {
            long sum=0;
            for(int i=1;i<=n;i+=2){
                sum+=i;
            }
            System.out.println("P3:1+3+5+...+n="+sum);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long begin=System.currentTimeMillis();

        Thread t1=new P1();
        Thread t2=new P2();
        Thread t3=new P3();

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();;
        t3.join();

        long end=System.currentTimeMillis();
        System.out.println("一共耗时"+(end - begin) * 1.0 / 1000);
    }
}
