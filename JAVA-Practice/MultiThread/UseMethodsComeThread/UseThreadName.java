public class UseThreadName {
    private static class MyThread extends Thread{
        public MyThread(){

        }
        public MyThread(String name){
            super(name);
        }

        @Override
        public void run() {
            while(true){
                System.out.println(Thread.currentThread().getName());
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new Thread();
        Thread t2=new MyThread();
        Thread t3 = new MyThread("我是AAA");
        /*
            注意：这里有 用无参构造方法创建一个对象
            若程序中存在有参构造方法，那么系统不会默认吧无参构造方法传进来
            所以必须要把无参构造方法写上

            若程序没有存在有参构造方法，那么系统会把父类默认的
            无参构造方法传进来，可以不用写
         */
        Thread t4=new Thread(new MyThread());
        Thread t5=new Thread(new MyThread(),"我是BBB");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
