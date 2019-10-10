class Node{
    int val;
    Node next;
}
//利用链表的头删，尾插建立的队列
public class MyQueue{
    private Node head=null;
    private Node tail=null;
    private int size=0;

    //头删
    public int pool(){
        Node first=head;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return first.val;
    }

    //尾插
    public void offer(int val){
        Node node=new Node();
        node.val=val;
        if(tail==null){
            node=head=tail;
        }else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

}
