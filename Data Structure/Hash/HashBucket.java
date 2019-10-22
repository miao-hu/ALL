/*  Key-Value模型实现哈希树
    负载因子大于临界值0.75就需要调整
    负载因子=哈希表内的元素个数/数组的长度
    哈希桶方式（链表存储）解决冲突问题
 */
public class HashBucket {
    private static class Node{
        private int key;
        private int value;
        private Node next;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private Node[] array; //哈希树实际上是用数组来实现的，数组中的每一个元素都存储Node结点
    private int size;  //数组中实际存放的结点个数
    public static final double LOAD_FACTOR=0.75;

    public HashBucket(){
        array=new Node[8];
        size=0;
    }

    //得到负载因子
    public double getLoadFactor(){
        return size*1.0/array.length;
    }

    //如果哈希树中有值为Key的结点，那么返回它的Value值
    public int get(int key){
        //1.由key推导出int类型的值
        //2.由Int类型的值验证下标的合法性
        int index=key%array.length;//哈希函数
        Node head=array[index];
        for(Node cur=head;cur!=null;cur=cur.next){
            if(key==cur.key){
                return cur.value;
            }
        }
        return -1;
    }

    //查询哈希表中是否有元素值为Key的结点，若有则更新它的值
    //若没有添加新节点   头插简单
    public int put(int key, int value){
        int index=key%array.length;
        Node head=array[index];
        for(Node cur=head;cur!=null;cur=cur.next){
            if(key==cur.key){
                int oldValue=cur.value;
                cur.value=value;
                return oldValue;
            }
        }
        //插入新节点
        Node node=new Node(key,value);
        //头插法
        node.next=array[index];
        array[index]=node;
        size++;
        //size++后负载因子就可能发生变化
        if(getLoadFactor()>LOAD_FACTOR){
            resize();//扩容
        }
        return -1;
    }

    //扩容
    private void resize() {
        Node[] newArray=new Node[array.length*2];
        for(int i=0;i<array.length;i++){
            Node next;
            for(Node cur=array[i];cur!=null;cur=next){
                next=cur.next;
                int index=cur.key%newArray.length;
                cur.next=newArray[index];
                newArray[index]=cur;
            }
        }
        array=newArray;
    }
}
