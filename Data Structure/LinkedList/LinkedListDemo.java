import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.addFirst("A");
        linkedList.addLast("B");
        linkedList.add("C");
        linkedList.addFirst("D");
        System.out.println(linkedList);//[D, A, B, C]
        System.out.println(linkedList.pollFirst());//D
        System.out.println(linkedList.pollFirst());//A
        System.out.println(linkedList);//[B, C]
    }
}
