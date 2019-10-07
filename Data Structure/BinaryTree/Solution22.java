import java.util.Arrays;
import java.util.Scanner;

/*
建立一颗二叉树，并且按照他的中序遍历打印它
该二叉树是按前序遍历输入的
 */
public class Solution {
    private static class Node{
        private char val;
        private Node left=null;
        private Node right=null;

        private Node(char val){
            this.val=val;
        }

    }
    private static class RT{
        private Node root;
        private int count;

        private RT(Node root,int count){
            this.root=root;
            this.count=count;
        }

    }

    private static RT buildTree(char[] preorder){
        if(preorder.length==0){
            return new RT(null,0);
        }
        if(preorder[0]=='#'){
            return new RT(null,1);
        }
        RT leftTree=buildTree(Arrays.copyOfRange(preorder,1,preorder.length));
        RT rightTree=buildTree(Arrays.copyOfRange(preorder,1+leftTree.count,preorder.length));
        Node root=new Node(preorder[0]);
        root.left=leftTree.root;
        root.right=rightTree.root;

        return new RT(root,1+leftTree.count+rightTree.count);
    }

    private static void inorderTraversal(Node root){
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root.val+" ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner intput=new Scanner(System.in);
        String s=intput.nextLine();
        char[] array=s.toCharArray();
        RT result=buildTree(array);
        inorderTraversal(result.root);
    }

}
