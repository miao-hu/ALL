import java.util.List;
import java.util.ArrayList;

public class ListDemo {
    public static void main(String[] args) {
        List<String> course=new ArrayList<>();
        course.add("C");
        course.add("Java");
        course.add("JavaSE");
        course.add("JavaEE");
        System.out.println(course);

        System.out.println(course.get(1));
        //System.out.println(course.get(8)); //有错误
        course.set(0,"计算机");
        System.out.println(course);

        List<String> sub=course.subList(1,3);//截取子串
        System.out.println(sub);

        List<String> list=new ArrayList<>(50);
        //System.out.println(list.get(5));
        //编译错误，因为里面没有元素
    }
}
