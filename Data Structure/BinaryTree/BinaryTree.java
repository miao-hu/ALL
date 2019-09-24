import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

public class BinaryTree{
    private static class Node{  //内部静态类  BinaryTree.Node
        private char val;       //Node类中的所有方法BinaryTree类都可以访问
        private Node left=null;
        private Node right=null;

        private Node(char val){
            this.val=val;
        }

        @Override
        public String toString() {
            return String.format("{%c}",val);
        }
    }

    public static Node buildTree(){
        Node a=new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        e.right = h;
        return a;  //返回跟部结点
    }

    //前序遍历
    public static void preOrderTraversal(Node root){
        //终止条件肯定与形参有关，因为递归的形参值一直在改变
        if(root==null){
            return;
        }
        // 根 + 左子树的前序遍历 + 右子树的前序遍历
        System.out.println(root);  //调用root.toString()方法
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //中序遍历
    public static void inOrderTraversal(Node root){
        if(root==null){
            return;
        }
        // 左子树的中序遍历 + 根 + 右子树的中序遍历
        inOrderTraversal(root.left);
        System.out.println(root);  //调用root.toString()方法
        inOrderTraversal(root.left);
    }

    //后序遍历
    public static void postOrderTraversal(Node root){
        if(root==null){
            return;
        }
        // 左子树的后序遍历  + 右子树的后序遍历+ 根
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root);  //调用root.toString()方法
    }

    //求二叉树的结点个数
    public static int getSize1(Node root){
        if(root==null){
            return 0;
        }
        int left=getSize1(root.left);  //左子树的结点个数
        int right=getSize1(root.right);//右子树的结点个数
        //汇总：左+右+根
        return left+right+1;
    }

    private static int count=0;
    public static int getSize2(Node root){
        if(root==null){
            return 0;
        }
        count++;
        getSize2(root.left);  //左子树的结点个数
        getSize2(root.right);//右子树的结点个数
        return count;
    }

    //二叉树的中序遍历
    private static List<Character> inorderReturnList1(Node root){
        List<Character> list=new ArrayList<>();
        if(root==null){
            return list;//返回一个空的顺序表
        }
        list.addAll(inorderReturnList1(root.left));
        list.add(root.val);
        list.addAll(inorderReturnList1(root.right));
        return list;
    }

    private static List<Character> inorderList=new ArrayList<>();
    private static void inorderReturnList2(Node root){
        if(root!=null){
            inorderReturnList2(root.left);
            inorderList.add(root.val);
            inorderReturnList2(root.right);
        }
    }

    //求叶子节点的个数
    public static int getLeafSize1(Node root){
        if(root==null){   //空二叉树
            return 0;
        }
        if(root.left==null&&root.right==null){  //只有根结点
            return 1;
        }
        int left=getLeafSize1(root.left);
        int right=getLeafSize1(root.right);
        return left+right;
    }

    private static int leafSize=0;
    public static int getLeafSize2(Node root){
        if(root==null){   //空二叉树
            return 0;
        }
        if(root.left==null&&root.right==null){
            leafSize++;
        }
        getLeafSize2(root.left);
        getLeafSize2(root.right);
        return leafSize;
    }

    //求二叉树的高度
    public static int getHeight(Node root){
        if(root==null){   //空二叉树
            return 0;
        }
        int left=getHeight(root.left);  //左子树的高度
        int right=getHeight(root.right);//右子树的高度
        return Math.max(left,right)+1;
    }

    //求第K层的节点个数
    public static int getKLevel(Node root, int k){
        if(root==null){   //空二叉树
            return 0;
        }
        if(k==1){   //只有一个根结点
            return 1;
        }
        return getKLevel(root.left, k-1)+getKLevel(root.right,k-1);
    }

    //查找val值所在的结点，没有找到返回Null，
    // 一旦找到立即返回该结点，不需要在其它位置再找
    public static Node find(Node root, int val){
        if(root==null){  //空二叉树
            return null;
        }
        if(root.val==val){  //刚好是根结点
            return root;
        }
        Node m=find(root.left,val);//左子树中找
        if(m!=null){  //找到了
            return m;
        }
        Node n=find(root.right,val);//右子树中找
        if(n!=null){  //找到了
            return n;
        }
        return null;
    }

    //查找val值所在的结点，找到返回true
    public static boolean find2(Node root, int val){
        if(root==null){  //空二叉树
            return false;
        }
        if(root.val==val){  //刚好是根结点
            return true;
        }
        if(find2(root.left,val)){
            return true;
        }
        return find2(root.right,val);
    }

    public static void main(String[] args) {
        Node root=buildTree();
        System.out.println("build tree is success!");
        System.out.println(root);  //{A}
        preOrderTraversal(root);
        System.out.println("-------------------");
        inOrderTraversal(root);
        System.out.println("-------------------");
        postOrderTraversal(root);
        System.out.println("-------------------");
        System.out.println("结点个数: " + getSize1(root));

        count = 0; //因为count是全局静态变量，必须置0
        System.out.println("结点个数: " +  getSize2(root));
        System.out.println("-------------------");
        System.out.println("叶子结点个数： "+getLeafSize1(root));

        leafSize = 0;//因为leafSize是全局静态变量，必须置0
        System.out.println("叶子结点个数： " + getLeafSize2(root));
        System.out.println("-------------------");
        System.out.println("二叉树的高度"+getHeight(root));
        System.out.println("-------------------");
        System.out.println("第K层的结点个数"+getKLevel(root, 1)); // 1
        System.out.println("第K层的结点个数"+getKLevel(root, 2)); // 2
        System.out.println("第K层的结点个数"+getKLevel(root, 3)); // 4
        System.out.println("第K层的结点个数"+getKLevel(root, 4)); // 1
        System.out.println("第K层的结点个数"+getKLevel(root, 5)); // 0
        System.out.println("-------------------");
        System.out.println("中序遍历"+inorderReturnList1(root));

        inorderList.clear();//顺序表清空
        inorderReturnList2(root);
        System.out.println("中序遍历"+inorderList);

    }
}
