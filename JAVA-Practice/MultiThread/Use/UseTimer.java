import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class UseTimer {
    private static class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("该起床了");
        }
    }

    public static void main(String[] args) {
        Timer timer=new Timer();
        //timer.schedule(TimerTask task,long delay);方法
        //public abstract class TimerTask extends Object implements Runnable

        timer.schedule(new MyTimerTask(),1000);
        System.out.println("我是另一个人");
        /*
        我是另一个人
        该起床了
         */
    }
}
