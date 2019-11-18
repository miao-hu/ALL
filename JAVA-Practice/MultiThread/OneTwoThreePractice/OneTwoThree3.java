public class OneTwoThree3 {
    private static class Foo{
        private  volatile int n=1;  //保证了可见性

        //减少了锁的开销
        public void oneMethod(){
            if(n!=1){
                return;
            }
            System.out.println("one");
            n=2;    //这句话一定要放在打印后边，因为线程调度发生在任何时刻
                    //如果刚开始进来n==1成立 ，然后n=2赋值，这时候发生线程调度，t2线程调度进来
                    //它的run 方法调用twoMethod方法，此时n==2成立，进来后赋值n=3，
                    //这个时候又不发生调度，然后就打印two   即没有打印one
        }
        public void twoMethod(){
            if(n!=2){
                return;
            }
            System.out.println("two");
            n=3;
        }
        public void threeMethod(){
            if(n!=3){
                return;
            }
            System.out.println("three");
            n=1;
        }
    }
    private static Foo foo=new Foo();
    private static class oneThread extends Thread{
        @Override
        public void run() {
            while(true){
                foo.oneMethod();
            }
        }
    }
    private static class twoThread extends Thread{
        @Override
        public void run() {
            while(true){
                foo.twoMethod();
            }
        }
    }
    private static class threeThread extends Thread{
        @Override
        public void run() {
            while(true){
                foo.threeMethod();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new oneThread();
        Thread t2=new twoThread();
        Thread t3=new threeThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
