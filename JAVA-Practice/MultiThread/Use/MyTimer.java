class MyTimer{
    public void execute(Runnable task, long delay){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(delay);
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
public class UseTimer1 {
    public static void main(String[] args) {
        MyTimer myTimer=new MyTimer();
        myTimer.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("该起床了");
            }
        },1000);
        System.out.println("我是另一个人");
    }
    /*
    我是另一个人
    该起床了
     */
}
