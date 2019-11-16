public class SynchronizedDemoStaticMethod {
    private static synchronized void staticMethod(){
        for(int i=0;i<10_0000;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            while(true) {
                SynchronizedDemoStaticMethod.staticMethod();
            }
        }
    }

    public static void main(String[] args) {
        Thread t=new MyThread();
        t.start();
        while(true) {
            SynchronizedDemoStaticMethod.staticMethod();
        }
    }
}
