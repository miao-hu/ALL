import javax.naming.ldap.PagedResultsControl;
import java.util.Comparator;
/*
自然顺序：JAVA中自带的   不需要第三方的参与
非自然顺序：需要第三方的参与，此时需要定义比较器
            比较器定义规则，按照这个标准判断谁大谁小

构建比较器不需要修改原类中的方法，它是独立的，所以赞成建造它
如果修改原类中的方法，那么就需要继承，但是继承不是一个好的思路
我们优先选取建造构造器

若一个类中没有自然顺序，那么需要比较的话就需要传一个比较器参数

String   Integer类天生具备自然顺序  直接调用即可
 */

//比较器
class PersonHeightComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.height-o2.height;
    }
}

class PersonNameComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}

class ComplexComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {     //复杂器：
        if(o1.age>o2.age){                         //如果两个对象的年龄相同，则比较身高
            return 1;                              //若身高还相同，则比较姓名
        }else if(o1.age<o2.age){                  //若姓名还相同，则比较体重
            return -1;
        }

        if(o1.height>o2.height){
            return 1;
        }else if(o1.height<o2.height){
            return -1;
        }

        int r=o1.name.compareTo(o2.name);
        if(r!=0){
            return r;
        }

        return o1.weight-o2.weight;
    }
}

public class Person implements Comparable<Person>{
    public String name;
    public int age;
    public int level;
    public int height;
    public int weight;
    public int gender;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override   //自然顺序
    public int compareTo(Person o) {
        return this.age-o.age;
        /*
                if(this.age>o.age){
                    return 1;
                }else  if(this.age==o.age){
                    return 0;
                }else {
                    return -1;
                }
         */
    }

    public static void main(String[] args) {

        //String   Integer类天生具备自然顺序  直接调用即可
        System.out.println("abc".compareTo("abcd")); // -1
        System.out.println("bbc".compareTo("zbc"));  //-24

        Person p=new Person("张三",18,165);
        Person q=new Person("李四",20,145);

        //自然顺序比较
        int result=p.compareTo(q);
        System.out.print("按照自然顺序比较:");
        if(result>0){
            System.out.println("p 比 q 大");
        }else if(result==0){
            System.out.println("p 和 q 相等");
        }else{
            System.out.println("p 比 q 小");      //p 比 q 小
        }

        //非自然顺序比较
        Comparator<Person> comparator=new PersonNameComparator();
        int r=comparator.compare(p,q);
        System.out.print("按照姓名比较：");
        if(r>0){
            System.out.println("p 比 q 大");
        }else if(r==0){
            System.out.println("p 和 q 相等");
        }else{
            System.out.println("p 比 q 小");      //p 比 q 小
        }


        comparator=new PersonHeightComparator();
        r=comparator.compare(p,q);
        System.out.print("按照身高比较：");
        if(r>0){
            System.out.println("p 比 q 大");
        }else if(r==0){
            System.out.println("p 和 q 相等");
        }else{
            System.out.println("p 比 q 小");      //p 比 q 大
        }

    }
}
