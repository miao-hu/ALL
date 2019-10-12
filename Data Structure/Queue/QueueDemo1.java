import java.util.LinkedList;
import java.util.Queue;

//队列
public class QueueDemo1 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("A");
        queue.add("B");
        queue.offer("C");
        queue.offer("D");
        System.out.println(queue);//[A, B, C, D]
        System.out.println(queue.isEmpty());
        System.out.println(queue.element());//A
        System.out.println(queue.element());//A
        System.out.println(queue.peek());//A
        System.out.println(queue.peek());//A
        System.out.println(queue.poll());//A
        System.out.println(queue.poll());//B
        System.out.println(queue.remove());//C
        System.out.println(queue.remove());//D
        System.out.println(queue.isEmpty());
    }
}
