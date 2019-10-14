import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection<String> list=new ArrayList<>();
        /* Collection相当于一个集合（容器）   里面的元素类型为String类型
            ArrayList实现了Collection接口
         */
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("======================");

        list.add("我");
        list.add("爱");
        list.add("Java");
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("======================");

        list.remove("我");
        for(String s:list){
            System.out.print(s+" ");
        }
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("======================");

        Object[] array=list.toArray();
        System.out.println(Arrays.toString(array));
        System.out.println("======================");

        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("======================");

        list.clear();
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
    }
}
