import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class TitleComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.title.compareTo(o2.title);
    }
}

class PrizeComparator implements Comparator<Book>{
    boolean asc;

    public PrizeComparator(boolean asc){
        this.asc=asc;
    }

    //true 代表 从小到大排，false 代表 从大到小排

    @Override
    public int compare(Book o1, Book o2) {
        if(asc){
            return o1.prize-o2.prize;
        }else{
            return o2.prize-o1.prize;
        }

    }
}

public class Book implements Comparable<Book>{
    String ISBN;
    String author;
    String title;
    int prize;
    int sales;
    int comments;

    public Book(String ISBN, String author, String title, int prize, int sales, int comments) {
        this.ISBN = ISBN;
        this.author = author;
        this.title = title;
        this.prize = prize;
        this.sales = sales;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return String.format("Book{ ISBN:%s   author:%s    title:%-11s   prizes:%-2d      sales:%-2d      comments:%-2d  }",ISBN,author,title,prize,sales,comments);
    }

    @Override
    public int compareTo(Book o) {
        return this.ISBN.compareTo(o.ISBN);
    }

    public static void main(String[] args) {
        List<Book> list=new ArrayList<>();
        list.add(new Book("161213215","张三","我的世界",58,500,680));
        list.add(new Book("192315651","李四","应物兄",98,785,1000));
        list.add(new Book("945613213","李华","从入门到精通",66,780,1200));
        list.add(new Book("816132132","王五","数据库",45,86,610));
        list.add(new Book("665323455","任倩","软件工程",99,590,1800));

        List<Book> copy;

        System.out.println("按自然顺序ISBN排序：");
        copy=new ArrayList<>(list);
        BookSort.sort(copy);
        for(int i=0;i<copy.size();i++)
        System.out.println(copy.get(i));
        System.out.println();

        System.out.println("按书名排序");
        copy=new ArrayList<>(list);
        BookSort.sort(copy,new TitleComparator());
        for(int i=0;i<copy.size();i++)
            System.out.println(copy.get(i));
        System.out.println();

        //按价格排序（从小到大）
        System.out.println("按价格从小到大排序:");
        copy=new ArrayList<>(list);
        BookSort.sort(copy,new PrizeComparator(true));
        for(int i=0;i<copy.size();i++)
            System.out.println(copy.get(i));
        System.out.println();

        //按价格排序（从大到小）
        System.out.println("按价格从大到小排序:");
        copy=new ArrayList<>(list);
        BookSort.sort(copy,new PrizeComparator(false));
        for(int i=0;i<copy.size();i++)
            System.out.println(copy.get(i));
    }
}

