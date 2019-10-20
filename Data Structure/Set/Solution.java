import java.util.*;

public class Solution {
    /*第三题：深拷贝：
                  给定一个链表，每个节点包含一个额外增加的随机指针，
                  该指针可以指向链表中的任何节点或空节点。
     */
    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
    /*方法1.按照普通方式拷贝
          （1）.先把链表改写成1-->1-->2-->2-->3-->3-->4-->4形式
          （2）.然后复制random
          （3）.拆分链表（拆分为两个链表）
     */
    public Node copyRandomList1(Node head) {
        Node cur=head;
        while(cur!=null){
            Node node=new Node();
            node.val=cur.val;

            node.next=cur.next;  //插入结点
            cur.next=node;

            cur=node.next;  //更新cur
        }
        //----------------------------------------------------
        cur=head;
        while(cur!=null){
            Node node=cur.next;  //同值的第二个结点
            if(cur.random!=null){
                node.random=cur.random.next;
            }else{
                node.random=null;  //cur没有指向的random，那么就指向Null
            }
            cur=node.next;
        }
        //---------------------------------------------------------
        cur=head;
        if(head==null){  //原链表就是空链表
            return null;
        }
        Node newHead=head.next;  //保存新链表的第一个结点
        while(cur!=null){
            Node node=cur.next;  //同值的第二个结点

            cur.next=node.next;  //第一个链表的连接
            if(node.next!=null) {
                node.next = node.next.next;
            }
            cur=cur.next;
        }
        return newHead;
    }

    /*方法2.按照Map方式拷贝
            （1）.遍历原链表，尾插法创建一个新的链表
                  同时把这两个当前结点插入到Map中
            （2）.复制random
            （3）.返回新链表
     */
    private static class NodeComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.val-o2.val;
        }
    }
    public Node copyRandomList2(Node head) {
        //因为TreeMap的实现必须带有顺序
        //而Node结点没有带有自然顺序的比较，所以必须定义比较器
        //而且作为参数传入
        Map<Node,Node> map=new TreeMap<>(new NodeComparator());
        Node newHead=null;  //新链表的头结点
        Node newLast=null;  //新链表的最后一个结点
        Node cur=head;
        while(cur!=null){
            Node node=new Node();
            node.val=cur.val;

            if(newHead==null){
                newHead=node;
            }else{
                newLast.next=node;
            }
            newLast=node; //更新最后一个结点的值

            map.put(cur,node);//吧cur和node放入Map
            cur=cur.next;
        }
        //--------------------------------------------------
        cur=head;
        Node node=newHead;
        while(cur!=null){
            if(cur.random!=null){
                node.random=map.get(cur.random);
            }else{
                node.random=null;
            }
            cur=cur.next;
            node=node.next;
        }
        return newHead;
    }
}
