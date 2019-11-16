public class SynchronizedDemo4 {
    public void menthod(){
        // 进入代码块会锁 SynchronizedDemo4.class 指向对象中的锁；
        // 出代码块会释放 SynchronizedDemo4.class 指向的对象中的锁
        synchronized (SynchronizedDemo4.class){

        }
    }

    public static void main(String[] args) {
        SynchronizedDemo3 o=new SynchronizedDemo3();
        o.menthod();
    }
}
