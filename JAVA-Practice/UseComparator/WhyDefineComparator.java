import javax.xml.soap.Node;

public class WhyDefineComparator {
    public static void main(String[] args) {
        Node p;
        Node q;
    }
    /*
        在这种情况下，若要比较两个对象，没有办法比较两个对象的引用
        不可以用p.compareTo(q)
        此时需要定义一个规则来判断两个引用谁大谁小
        这是就需要构造  比较器   它用来定义规则
     */
}
