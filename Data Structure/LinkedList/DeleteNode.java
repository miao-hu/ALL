//删除链表中的重复结点
class Node{
    int val;
    Node next;
}
public class Soultion {
    public Node deleteDuplicated(Node head){
        if(head==null)return null;
        if(head.next==null)return head;
        Node prev=new Node();//先创建一个结点
        prev.next=head;
        Node first=prev;//保存prev
        Node p=head;
        Node q=head.next;//用来遍历链表
        while(q!=null){
            if(p.val!=q.val){
                prev=p;
                p=q;
                q=q.next;
            }else{
                while(q!=null&&p.val==q.val){
                    q=q.next;
                }
                prev.next=q;
                p=q;
                if(q!=null){
                    q=q.next;
                }
            }
        }
        return first.next;
    }
}
