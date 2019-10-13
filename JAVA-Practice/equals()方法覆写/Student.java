//重载Object.equals()方法
public class Student {
    public String sn;  //学号
    public String name;//姓名
    public int age;    //年龄
    public int gender; //性别

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        Student s = (Student) obj;
        return sn.equals(s.sn);

        //return sn.equals(((Student)obj).sn);

    }
}
