import java.util.LinkedList;//队列
import java.util.Queue;//栈

//用队列实现栈
public class MyStack {
    private Queue<Integer> queue;
    public MyStack(){
        queue=new LinkedList<>();
    }
    public void push(int x){
        queue.offer(x);//压栈
    }
    public int pop(){
        int size=queue.size();
        for(int i=0;i<size-1;i++){
            int v=queue.poll();
            queue.offer(v);
        }
        size--;
        return queue.poll();
    }
    public int top(){
        int size=queue.size();
        for(int i=0;i<size-1;i++){
            int v=queue.poll();
            queue.offer(v);
        }
        int v=queue.poll();
        queue.offer(v);
        return v;
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
