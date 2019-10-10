//循环队列
public class MyCircularQueue {
    private int[] array;
    private int size=0;
    private int rear=0;
    private int front=0;
    public  MyCircularQueue(int k){
        array=new int[k];
    }
    public boolean enQueue(int value){
        if(size==array.length){
            return false;
        }
        array[rear]=value;
        rear=(rear+1)%array.length;
        size++;
        return true;
    }
    public boolean deQueue(){
        if(size==0){
            return false;
        }
        front=(front+1)%array.length;
        size--;
        return false;
    }
    public int Front(){
        if(size==0){
            return -1;
        }
        return array[front];
    }
    public int Rear(){
        if(size==0){
            return -1;
        }
        int index=(rear-1+array.length)%array.length;
        return array[index];
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==array.length;
    }

}
