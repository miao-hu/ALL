public class SynchronizedDemo3 {
    public void menthod(){
        //进入代码块会锁this指向对象中的锁
        //出代码块会释放this指向的对象中的锁
        synchronized (this){

        }
    }

    public static void main(String[] args) {
        SynchronizedDemo3 o=new SynchronizedDemo3();
        o.menthod();
    }
}
