//顺序表
//子类
import java.util.Arrays;
public class ArrayList extends List{
    private int[] a=new int[10]; //只有本类可以访问

    @Override
    public void insert(int index, int element) {
        for(int i=size;i>index;i--){
            a[i]=a[i-1];
        }
        a[index]=element;
        size++;
    }

    public void print(){
        System.out.println(Arrays.toString(Arrays.copyOfRange(a,0,size)));
    }

    /*  print()方法注解
        int[] array=Arrays.copyOfRange(a,0,size);
        String s=Arrays.toString(array);
        System.oy.println(s);
     */
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.pushFront(1);
        list.pushFront(2);
        list.pushFront(3);
        list.print();
        list.pushBack(10);
        list.pushBack(20);
        list.pushBack(30);
        list.print();
        list.insert(2,100);
        list.insert(3,200);
        list.print();
    }
}
