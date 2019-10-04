import java.util.Arrays;
import java.util.Comparator;

class Student{
    String sn;
    String name;
    int age;
}

class Cmp implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return 0;
    }
}
public class StudentSort {

    public static void insertSort(Student[] students){
        for(int i=1;i<students.length;i++){
            Student k=students[i];
            int j=i-1;   //其实不能用，类中没有复写compareTo()方法
            for(;j>=0&&((Comparable<Student>)students[j]).compareTo(k)>0;j--){
                students[j+1]=students[j];
            }
            students[j+1]=k;
        }
    }

    public static void insertSort(Student[] students, Comparator<Student> cmp){
        for(int i=1;i<students.length;i++){
            Student k=students[i];
            int j=i-1;
            for(;j>=0&&cmp.compare(students[j],k)>0;j--){
                students[j+1]=students[j];
            }
            students[j+1]=k;
        }
    }

    public static void main(String[] args) {
        Student[] students = { new Student(), new Student(), new Student()};
        //insertSort(students);   报错
        //Arrays.sort(students);  报错
        //---------这两者报错的原因都是原类没有自然顺序的比较
        insertSort(students,new Cmp());
        Arrays.sort(students,new Cmp());
    }
}


