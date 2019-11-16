public class SynchronizedDemoPublicMethod {
    public synchronized void method(){
        // 具体代码
        for(int i=0;i<10_0000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    //普通方法
    public void method1(){
    }

    public synchronized static void staticMethod(){
        // 具体代码
    }

    public void block(){
        synchronized (this){
            // 具体代码
        }
    }
    private static class Mythread extends Thread{
        public SynchronizedDemoPublicMethod object;
        public Mythread(SynchronizedDemoPublicMethod object){
            this.object=object;
        }

        @Override
        public void run() {
            while(true)
                object.method();
        }
    }

    public static void main(String[] args) {
        SynchronizedDemoPublicMethod object=new SynchronizedDemoPublicMethod();
        Thread t=new Mythread(object);
        t.start();
        while(true){
            object.method();
        }
    }
}
