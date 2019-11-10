/*
NEW
RUNNABLE
BLOCKED
WAITING
TIMED_WAITING
TERMINATED
 */
public class ThreadState {
    public static void main(String[] args) {
        for(Thread.State state:Thread.State.values()){
            System.out.println(state);
        }
    }
}
