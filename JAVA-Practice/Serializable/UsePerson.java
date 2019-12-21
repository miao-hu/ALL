import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class UsePerson {
    public static void main(String[] args) throws IOException {
        Person p=new Person("张三",18);
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Person对象.obj"));
        oos.writeObject(p);
        System.out.println("序列化成功");
        oos.close();
    }
}
