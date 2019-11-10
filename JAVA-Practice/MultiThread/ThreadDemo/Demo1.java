/*
张三李四交替打印
 */
public class Demo1 {
    private static class Printer张三 implements Runnable{

        @Override
        public void run() {
            while(true){
                System.out.println("张三");
            }
        }
    }
    private static class Printer李四 implements Runnable{

        @Override
        public void run() {
            while(true){
                System.out.println("李四");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread 张三=new Thread(new Printer张三());
        Thread 李四=new Thread(new Printer李四());
        张三.start();
        张三.join();  //加上这个  那个一直打印张三   因为循环无法退出
        李四.start();
    }
}
