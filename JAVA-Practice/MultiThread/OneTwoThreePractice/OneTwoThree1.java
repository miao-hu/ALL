/*
不管怎样只能打印onetwothree   循环打印
 */
public class OneTwoThree1 {
    private static class Foo{
        private  int n=1;

        // 虽然 n 不为 1，return  ,但是while循环无法退出
        // 一直循环，run方法没有执行完，不让出 CPU，导致 n 无法及时变化
        public void oneMethod(){
            synchronized (this){
                if(n!=1){
                    return;
                }
                n=2;
                System.out.println("one");
            }
        }
        public void twoMethod(){
            synchronized (this){
                if(n!=2){
                    return;
                }
                n=3;
                System.out.println("two");
            }
        }
        public void threeMethod(){
            synchronized (this){
                if(n!=3){
                    return;
                }
                n=1;
                System.out.println("three");
            }
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
