import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tree {
    private static class Node{
        private int val;
        private Node left=null;
        private Node right=null;

        private Node(int val){
            this.val=val;
        }

    }

    //建立二叉树
    public static Node buildTree() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n1.left = n2; n1.right = n3;
        n2.left = n4;
        n3.left = n5; n3.right = n6;

        return n1;
    }

    //非递归前序遍历树
    public static void preOrder(Node root){
        Stack<Node> stack=new Stack<>();  //先进后出用栈
        Node cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){  //cur为Null则退出，准备从栈中回退，访问右结点
                System.out.print(cur.val+" ");
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
    }

    public List<Integer> preorderTraversal(Node root){
        List<Integer> list=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            cur=top.right;
        }
        return list;
    }

    //非递归中序遍历树
    public static void inOrder(Node root){
        Stack<Node> stack=new Stack<>();  //先进后出用栈
        Node cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){  //cur为Null则退出，准备从栈中回退
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            System.out.print(top.val+" ");
            cur=top.right;
        }
    }

    public List<Integer> inorderTraversal(Node root){
        List<Integer> list=new ArrayList<>();
        Stack<Node> stack=new Stack<>();
        Node cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            Node top=stack.pop();
            list.add(top.val);
            cur=top.right;
        }
        return list;
    }

    //非递归后序遍历树
    public static void postOrder(Node root){
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node last = null;   // 上次被遍历完的结点
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            Node top = stack.peek();
            if (top.right == null || top.right == last) {
                System.out.print(top.val+" ");
                stack.pop();
                last = top;
            } else {
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        Node root=buildTree();
        preOrder(root);  //前序遍历
        System.out.println("\n==================");
        inOrder(root);  //中序遍历
        System.out.println("\n==================");
        postOrder(root);//后序遍历
    }
}
