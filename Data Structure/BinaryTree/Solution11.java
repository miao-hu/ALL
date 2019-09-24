import java.util.ArrayList;
import java.util.List;

class Node {
    int val;
    Node left = null;
    Node right = null;

    private Node(char val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("{%c}", val);
    }
}

public class Solution11 {

    //1.二叉树的前序遍历
    public  List<Integer> list=new ArrayList<>();
    public void preorder(Node root){
        if(root!=null){
            list.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
    public List<Integer> preorderTraversal1(Node root){
        list.clear();
        preorder(root);
        return list;
    }

    //2.二叉树的前序遍历
    public List<Integer> preorderTraversal2(Node root){
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> left=preorderTraversal2(root.left);
        List<Integer> right=preorderTraversal2(root.right);

        List<Integer> list=new ArrayList<>();
        list.add(root.val);
        list.addAll(left);
        list.addAll(right);
        return list;
    }

    //3.判断两个树是镜像树，对称树
    public boolean isMirrorTree(Node p,Node q){
        if(p==null&&q==null){ //两个都是空树
            return true;
        }
        if(p==null||q==null){//一个为空树
            return false;
        }
        return p.val==q.val&&isMirrorTree(p.left,q.right)&&isMirrorTree(p.right,q.left);
    }

    //4.判断一个二叉树是否是另一棵二叉树的子树
    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {  //两个都是空树
            return true;
        }
        if (p == null || q == null) {//只有一个成立
            return false;
        }
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public boolean search(Node root,Node t){
        if(root==null){
            return false;
        }
        if(isSameTree(root,t)){
            return true;
        }
        if(search(root.left,t)){
            return true;
        }
        return search(root.right,t);  //返回true或false
    }
    public boolean isSubTree(Node s,Node t){
        return search(s,t);
    }

    //5.判断一个树是不是平衡二叉树
    public int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        return Math.max(left,right)+1;
    }
    public boolean isBalanced(Node root){
        if(root==null){ //空树
            return true;
        }
        if(!isBalanced(root.left)){
            return false;
        }
        if(!isBalanced(root.right)){
            return false;
        }
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        int diff=left-right;
        if(diff>=-1&&diff<=1){
            return true;
        }
        return false;
    }
}
