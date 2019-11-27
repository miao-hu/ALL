package timer;
//Timer.schedule(TimerTask task,long delay)
//public abstract class TimerTask implements Runnable

public class MyTimerTask implements Comparable<MyTimerTask> {
    Runnable target;   //任务
    long delay;        //延迟时间

    MyTimerTask(Runnable target, long delay) {
        this.target = target;
        this.delay = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        if (delay == o.delay) {
            return 0;
        } else if (delay < o.delay) {
            return -1;
        } else {
            return 1;
        }
    }
}
