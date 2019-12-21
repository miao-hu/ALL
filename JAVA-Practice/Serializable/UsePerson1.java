import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class UsePerson1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Person对象.obj"));
        Person p=(Person)ois.readObject();
        System.out.println(p);
        System.out.println("反序列化成功");
        ois.close();
    }
}
