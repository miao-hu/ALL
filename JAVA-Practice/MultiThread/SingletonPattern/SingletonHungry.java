/*
单例模式---饿汉模式
 */
public class SingletonHungry {
    private static SingletonHungry instance=new SingletonHungry();
    // 不允许外边调用构造方法
    private SingletonHungry(){

    }
    public static SingletonHungry getInstance(){
        return instance;
    }
}
