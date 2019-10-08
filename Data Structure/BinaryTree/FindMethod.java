public class FindMethod {
   public Node search1(Node root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        Node left=search1(root.left,val);
        if(left!=null){
            return left;
        }
        return search1(root.right,val);
    }

    public boolean search2(Node root, int val) {
        if(root==null){
            return false;
        }
        if(root.val==val){
            return true;
        }
        if(search2(root.left,val)){
            return true;
        }
        return search2(root.right,val);
    }

    public boolean isSameTree(Node p,Node q) {
       if(p==null)return false;
       if(p==q)return true;
       return p.val==q.val&&isSameTree(p.left,q.left)
               &&isSameTree(p.right,q.right);
    }
    public boolean search3(Node root,Node subRoot) {
        if(root==null){
            return false;
        }
        if(isSameTree(root,subRoot)){
            return true;
        }
        if(search3(root.left,subRoot)){
            return true;
        }
        return search3(root.right,subRoot);
    }

    public boolean search4(Node root,Node node) {
        if(root==null){
            return false;
        }
        if(root==node){
            return true;
        }
        if(search4(root.left,node)){
            return true;
        }
        return search4(root.right,node);
    }
}
