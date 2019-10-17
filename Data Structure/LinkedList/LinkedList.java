//链表
//子类
import java.util.Arrays;//引入这个包

class Node{
    int val;
    Node next;
}
public class LinkedList extends List{
    private Node head=null;  //链表的第一个结点


    @Override
    public void insert(int index, int element) {
        Node node=new Node();  //把插入的元素包装到一个结点中
        node.val=element;
        if(index==0){  //头插
            node.next=head;
            head=node;
        }else if(index==size){ //尾插
            Node last=head;
            while(last.next!=null){
                last=last.next;  //找到当前链表的最后一个结点
            }
            last.next=node;
            last=node;
            last.next=null;
        }else{  //中间任意位置插
            Node prev=head;
            for(int i=0;i<index-1;i++){
                prev=prev.next;   //找到插入位置的前驱结点
            }
            node.next=prev.next;
            prev.next=node;
        }
        size++;
    }

    public void print(){
        //先把链表中的值复制到一个数组中
        int[] array=new int[size];
        Node cur=head;
        for(int i=0;i<size;i++){
            array[i]=cur.val;
            cur=cur.next;
        }
        String s=Arrays.toString(array);
        System.out.println(s);
    }

    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.pushFront(4);
        list.pushFront(5);
        list.pushFront(6);
        list.print();
        list.pushBack(50);
        list.pushBack(60);
        list.pushBack(70);
        list.print();
        list.insert(2,100);
        list.insert(3,200);
        list.print();
    }
}
