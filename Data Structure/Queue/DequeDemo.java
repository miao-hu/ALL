import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Deque;
import java.util.LinkedList;

//Таѕ
public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque=new LinkedList<>();
        deque.addFirst("A");
        deque.add("B");
        deque.addFirst("C");
        deque.addLast("D");
        System.out.println(deque);//[C,A,B,D]
        System.out.println(deque.peekFirst());//C
        System.out.println(deque.getLast());//D
        deque.offerFirst("E");
        deque.offerLast("F");
        System.out.println(deque);//[E, C, A, B, D, F]
    }
}
