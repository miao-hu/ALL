/*
懒汉模式---多线程版本---性能低（锁的粗粒度）
 */
public class SingletonLazy2 {
    private static SingletonLazy2 instance=null;
    private SingletonLazy2(){

    }
    //保证了原子性
    public static synchronized SingletonLazy2 grtInstance(){
        if(instance==null){
            instance=new SingletonLazy2();
        }
        return instance;
    }
}
