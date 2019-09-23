import java.util.PriorityQueue;

public class MyPriorityQueue {
    private int[] array;  //定义一个数组存放二叉树的结点值
    private int size=0;   // 数组中的结点个数

    MyPriorityQueue(){
        array=new int[20];
        size=0;
    }

    //入队列（以大根堆为准）
    public  void offer1(int element){
        array[size++]=element;
        Heap.shiftUpBig(array,size-1);
    }

    //入队列（以小根堆为准）
    public void offer2(int element){
        array[size++]=element;
        Heap.shiftUpSmall(array,size-1);
    }

    //出队列（以大根堆为准）
    public int poll1(){
        int t=array[0];
        array[0]=array[--size];//将最后一个结点的值放到第一个结点的位置
        Heap.shiftDownBig(array,0,size);
        return t;
    }

    //出队列（以小根堆为准）
    public int poll2(){
        int t=array[0];
        array[0]=array[--size];//将最后一个结点的值放到第一个结点的位置
        Heap.shiftDownSmall(array,0,size);
        return t;
    }

    public int peek(){
        return array[0];
    }

    public static void main(String[] args) {
        MyPriorityQueue queue=new MyPriorityQueue();
        queue.offer1(7);
        queue.offer1(9);
        queue.offer1(5);
        System.out.println(queue.poll1());   // 9
        queue.offer1(3);
        System.out.println(queue.poll1());   // 7
        queue.offer1(10);
        queue.offer1(8);
        System.out.println(queue.poll1());   // 10
        System.out.println(queue.poll1());   // 8
        System.out.println(queue.poll1());   // 5
        System.out.println(queue.poll1());   // 3
        System.out.println("==================");
        PriorityQueue<Integer> q=new PriorityQueue();
        q.offer(8);
        q.offer(20);
        q.offer(15);
        System.out.println(q.poll());  //8  小堆
    }
}

