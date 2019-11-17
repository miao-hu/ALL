/*
 懒汉模式---多线程版---二次判断-性能高
 */
public class SingletonLazy3 {
    //保证可见性
    private static volatile SingletonLazy3 instance=null;
    private SingletonLazy3(){

    }

    public static SingletonLazy3 grtInstance(){
        if(instance==null){
            //保证原子性
            synchronized (SingletonLazy3.class) {
                if(instance==null) {
                    instance=new SingletonLazy3();
                }
            }
        }
        return instance;
    }
}
