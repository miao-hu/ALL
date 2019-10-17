class Node{
    int val;
    Node next;

    public Node(int val){
        this.val=val;
        next=null;
    }
}


public class Soution {
    //逆置链表1
    public static Node reverse1(Node head){
        Node p1=null;
        Node p2=head;
        Node p3=head.next;
        while(p2!=null){
            p2.next=p1;
            p1=p2;
            p2=p3;
            if(p3!=null){
                p3=p3.next;
            }
        }
        return p1;
    }

    //逆置链表2(把链表中的结点头插到一个新的空链表）
    public static Node reverse2(Node head){
        Node result=null;
        Node cur=head;
        while(cur!=null){//遍历旧链表
            Node next=cur.next;//保留当前结点的下一个结点
            cur.next=result;
            result=cur;
            cur=next;//更新cur
        }
        return result;
    }

    //逆置链表3(递归法）
    public static Node reverse3(Node head){
        if(head==null||head.next==null) {
            return head;
        }
        Node result=reverse3(head.next);
        head.next.next=head;
        head.next=null;
        return result;
    }

    //合并有序链表(新链表分情况讨论）
    public static Node merge1(Node head1,Node head2){
        if(head1==null)return head2;
        if(head2==null)return head1;
        Node p1=head1;
        Node p2=head2;
        Node result=null;
        Node last=null;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                if(result==null){
                    result=p1;
                }else{
                    last.next=p1;
                }
                last=p1;
                p1=p1.next;
            }
            else{
                if(result==null){
                    result=p2;
                }else{
                    last.next=p2;
                }
                last=p2;
                p2=p2.next;
            }
        }
        if(p1!=null){
            last.next=p1;
        }else{
            last.next=p2;
        }
        return result;
    }

    //合并有序链表（新链表中有一个结点存在）
    public static Node merge2(Node head1,Node head2){
        if(head1==null)return head2;
        if(head2==null)return head1;
        Node p1=head1;
        Node p2=head2;
        Node result=new Node(1);
        Node last=result;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                last.next=p1;
                p1=p1.next;
            }
            else{
                last.next=p2;
                p2=p2.next;
            }
            last=last.next; //更新最后一个结点
        }
        if(p1!=null){
            last.next=p1;
        }else{
            last.next=p2;
        }
        return result.next;
    }
}
