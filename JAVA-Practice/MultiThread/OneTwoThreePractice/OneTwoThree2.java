/*
不管怎样只能打印onetwothree    打印一次
 */
public class OneTwoThree2 {
    private static class Foo{
        private  int n=1;
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
                foo.oneMethod();
        }
    }
    private static class twoThread extends Thread{
        @Override
        public void run() {
                foo.twoMethod();
        }
    }
    private static class threeThread extends Thread{
        @Override
        public void run() {
                foo.threeMethod();
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
