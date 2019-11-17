/*
懒汉模式---单线程版本：
                    单线程环境下正确
                    多线程环境下有线程安全问题
 */
public class SingletonLazy1 {
    private static SingletonLazy1 instance=null;
    private SingletonLazy1(){

    }
    // getInstance方法被第一次调用时，意味着有人需要 instance
    // 然后进行初始化
    public static SingletonLazy1 grtInstance(){
        if(instance==null){
            instance=new SingletonLazy1();
        }
        return instance;
    }
}
