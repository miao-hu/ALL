public class SynchronizedDemo2 {
    private static synchronized void staticMethod(){

    }

    public static void main(String[] args) {
        staticMethod();
        // 进入方法会锁 SynchronizedDemo2.class 指向对象中的锁
        // 出方法会释放 SynchronizedDemo2.class 指向的对象中的锁
    }
}
