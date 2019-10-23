import java.util.Objects;

class Student{   //自定义类型的类
    String sn;  // 学号，学号相同，就是同一个人

    public Student(String sn){
        this.sn=sn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(sn, student.sn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sn);
    }
}

public class HashBucket<K,V> {
    private static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next;

        public Node(K key,V value){
            this.key=key;
            this.value=value;
        }
    }

    private Node<K,V>[] array=(Node<K,V>[])new Node[8];
    private int size=0;

    //注意：key是引用类型
    public V get(K key){
        int hash=key.hashCode();  //把key转化为int类型
        int index=hash%array.length;  //把int类型转化为合法下标
        Node<K,V> head=array[index];
        for(Node<K,V> cur=head;cur!=null;cur=cur.next){
            if(key.equals(cur.key)){  //比较引用的相等用equals()
                return cur.value;
            }
        }
        return null;//没有返回Null
    }

    public static void main(String[] args) {
        HashBucket<Student,String> hash=new HashBucket<>();
        Student p=new Student("123");
        Student q=new Student("123");
        System.out.println(p.equals(q)); //true

        //如果不覆写hashCode()方法，那么调用该方法产生的数字不一样
        System.out.println(p.hashCode());  //48721
        System.out.println(q.hashCode());  //48721

        //hash.put(p,"张定玉");
        //System.out.println(hash.get(p));

        System.out.println(hash.get(p));//null
    }
}
