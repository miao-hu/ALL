/*
  自定义一个队列的实现
*/
public class Queue {
    private int[] data;         //存放数据的数组
    private int front=0;        //队列头所在的索引
    private int rear=0;         //队列尾所在的索引
    private int size=0;         //队列的大小

    public Queue(int size) {
        this.size = size;      //队列的大小
        data = new int[size];  //初始化数组
    }

    /**
     * 入队操作
     * @param value
     */
    public void in(int value) throws Exception {
        if(rear == size){
            throw  new Exception("队列已经满了");
        }
        data[rear++] = value;
    }

    /**
     * 出队操作
     */
    public int out() throws Exception {
        if(isEmpty()){
            throw  new Exception("队列是空队列");
        }
        int value = data[front];
        front++;
        return value;
    }

    /**
     * 队列是否为空队列
     * @return
     */
    public boolean isEmpty(){
        return  front == rear;
    }

    /**
     * 遍历队列中的元素
     */
    public void traverse(){
        for(int i = front; i < rear; i++){
            System.out.println(data[i]+" ");
        }
    }
}

