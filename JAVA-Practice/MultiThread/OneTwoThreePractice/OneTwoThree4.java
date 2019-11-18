public class OneTwoThree4{
    private static class Foo{
        private  volatile int n=1;  //保证了可见性

        // 这个操作条件不满足时及时释放 CPU的占有权
        // 但是还参与 CPU 的争夺，而且再次争夺到的几率比较大
        public void oneMethod(){
            if(n!=1){
                // Thread.yield(); 通过调用 yield 释放 CPU
                // 可以适当增加性能
                Thread.yield();
                return;
            }
            System.out.println("one");
            n=2;
        }
        public void twoMethod(){
            if(n!=2){
                Thread.yield();
                return;
            }
            System.out.println("two");
            n=3;
        }
        public void threeMethod(){
            if(n!=3){
                Thread.yield();
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
