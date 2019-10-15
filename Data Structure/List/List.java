//定义一个接口（接口中的方法都不实现,只定义）
public interface List {
    void pushFront(int element);
    void pushBack(int element);
    void insert(int index,int element);
}

class Node{
    int val;
    Node next;
}

//定义一个抽象类AbstractList实现接口List
abstract class AbstractList implements List{
    protected int size=0;

    @Override
    public void pushFront(int element) {
        insert(0,element);
    }

    @Override
    public void pushBack(int element) {
        insert(size,element);
    }
}

//定义一个类ArrayList继承抽象父类AbstractList并且实现接口List
class ArrayList extends AbstractList implements List{
    private int[] array=new int[10];
    @Override
    public void insert(int index, int element) {
        for(int i=size;i>index;i--){
            array[i]=array[i-1];
        }
        array[index]=element;
        size++;
    }
}

//定义一个类LinkedList继承抽象父类AbstractList并且实现接口List
class LinkedList extends AbstractList implements List{
    private Node head=null;

    @Override
    public void insert(int index, int element) {
        Node node=new Node();
        node.val=element;
        if(index==0){
            node.next=head;
            head=node;
        }else if(index==size){
            Node last=head;
            while(last.next!=null){//注意是last.next!=null
                last=last.next;
            }
            last.next=node;
            last=node;
            last.next=null;
        }else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
        size++;
    }
}
