//线性表
//父类
public class List1 {
    protected int size=0;

    //往下标为Index处插入元素
    public void insert(int index,int element){
        System.out.println("父类中的方法，并没有实现");
    }

    //头插
    public void pushFront(int element){
        insert(0,element);
    }

    //尾插
    public void pushBack(int element){
        insert(size,element);
    }
}
