import java.util.ArrayList;
import java.util.List;

public class MyString {
    //一个静态属性模拟常量池,共享
    // 常量池：
    // 1. 作用: 节省内存空间
    // 2. 保证: 常量池中不会出现重复的对象
    private static List<MyString> constPool=new ArrayList<>();

    // String s = "hello";
    public static MyString literal(MyString s){
        // 1. 先找，找到直接返回常量池中的对象引用
        // 2. 否则，创建并入池，返回池中对象引用
        int index=constPool.indexOf(s);
        if(index==-1){
            constPool.add(s);
            return s;
        }
        return constPool.get(index);
    }


    // String s = ...;
    // String t = s.intern();
    public MyString intern() {
        int i = constPool.indexOf(this);
        if (i == -1) {
            constPool.add(this);
            return this;
        }

        return constPool.get(i);
    }
}

/*
    String.intern()使用原理：
    当通过语句str.intern()调用该方法时，JVM就会在当前类的常量池中查找是否存
    在与str等值的String,若存在则直接返回常量池中相应String的引用，若不存在，
    则会在常量池中创建一个等值的String，然后返回这个String在常量池中的引用。
 */
