import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> bucket=new TreeSet<>();
        bucket.add("香蕉");
        bucket.add("葡萄");
        bucket.add("苹果");
        bucket.add("西瓜");
        System.out.println(bucket); //[苹果, 葡萄, 西瓜, 香蕉]
        System.out.println(bucket.size());  //4
        System.out.println(bucket.contains("火龙果")); //false
        System.out.println(bucket.contains("西瓜")); //true
        System.out.println(bucket.add("西瓜")); //false
        System.out.println(bucket.remove("苹果"));
        System.out.println(bucket); //[葡萄, 西瓜, 香蕉]
        bucket.clear();
        System.out.println(bucket.size());  //0
    }
}
