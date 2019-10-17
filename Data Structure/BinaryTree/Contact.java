public class Contact {
    public static class Node{
        String name;
        String phone;
        Node left;
        Node right;

        public Node(String name,String phone){
            this.name=name;
            this.phone=phone;
        }
    }

    private Node root=null;

    public boolean insert(String name,String phone){
        if(root==null){
            root=new Node(name,phone);
            return true;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            int result=name.compareTo(cur.name);  //String自带自然顺序的比较
            if(result==0){
                return false;
            }else if(result<0){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }  //到这里整个搜索树没有该结点，可以插入
        Node node=new Node(name,phone);
        if(parent.name.compareTo(name)<0){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return true;  //插入成功
    }

    public String update(String name, String phone){
        Node cur=root;
        while(cur!=null){
            int result=name.compareTo(cur.name);  //String自带自然顺序的比较
            if(result==0){
                String oldPhone=cur.phone;
                cur.phone=phone;
                return oldPhone;
            }else if(result<0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }

    public String search(String name){
        Node cur=root;
        while(cur!=null){
            int result=name.compareTo(cur.name);  //String自带自然顺序的比较
            if(result==0){
                return cur.phone;
            }else if(result<0){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;
    }
}
