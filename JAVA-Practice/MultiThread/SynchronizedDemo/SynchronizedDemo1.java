public class SynchronizedDemo1 {
    private synchronized void method(){

    }

    public static void main(String[] args) {
        SynchronizedDemo1 o=new SynchronizedDemo1();
        o.method();
        // 进入方法会锁 o 指向对象中的锁；出方法会释放 o 指向的对象中的锁
    }
}
