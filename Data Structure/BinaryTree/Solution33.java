import java.util.Arrays;

public class Practice {

    //1. 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
    //（1）查找q结点是否在p这个二叉树中
    public boolean search(Node p,Node q){
        if(p==null)return false; //p为空二叉树
        if(p==q)return true;
        if(search(p.left,q))return true; //从左子树中查
        return search(p.right,q); //从右子树中查
    }
    //（2）找最近公共祖先
    public Node lowestCommonAncestor(Node root,Node p,Node q){
        if(p==root||q==root){  //p,q任意一个为根结点，祖先就为root
            return root;
        }
        boolean pInLeft=search(root.left,p);
        boolean qInLeft=search(root.left,q);
        if(pInLeft&&qInLeft){  //p,q都在左子树
            return lowestCommonAncestor(root.left,p,q);
        }
        if(!pInLeft&&!qInLeft){ //p,q都在右子树
            return lowestCommonAncestor(root.right,p,q);
        }
        return root; //p,q一个在左子树一个在右子树
    }

    //2.根据一颗二叉树的中序和后序遍历构造二叉树
    public Node buildTree(int[] inorder,int[] postorder){
        if(inorder.length==0){
            return null;
        }
        int rootValue=postorder[postorder.length-1];
        int leftCount;
        for(leftCount=0;leftCount<inorder.length;leftCount++){
            if(inorder[leftCount]==rootValue){
                break;
            }
        }
        Node root=new Node(rootValue);
        int[] leftInorder=Arrays.copyOfRange(inorder,0,leftCount);
        int[] leftPostorder=Arrays.copyOfRange(postorder,0,leftCount);
        root.left=buildTree(leftInorder,leftPostorder);
        int[] rightInorder=Arrays.copyOfRange(inorder,leftCount+1,inorder.length);
        int[] rightPostorder=Arrays.copyOfRange(postorder,leftCount,postorder.length-1);
        root.right=buildTree(rightInorder,rightPostorder);
        return root;
    }

    //3.根据一颗二叉树的前序和中序遍历构造二叉树
    public Node buildTree1(int[] preorder, int[] inorder){
        if(preorder.length==0){
            return null;
        }
        int rootValue=preorder[0];//先把根的值取出来
        int leftCount;//统计左子树的结点个数
        for(leftCount=0;leftCount<inorder.length;leftCount++ ){
            if(inorder[leftCount]==rootValue){
                break;
            }
        }
        Node root=new Node(rootValue);
        int[] leftPreorder=Arrays.copyOfRange(preorder,1,leftCount+1);
        int[] leftInorder=Arrays.copyOfRange(inorder,0,leftCount);
        root.left=buildTree1(leftPreorder,leftInorder);
        int[] rightPreorder=Arrays.copyOfRange(preorder,leftCount+1,preorder.length);
        int[] rightInorder=Arrays.copyOfRange(inorder,leftCount+1,inorder.length);
        root.right=buildTree1(rightPreorder,rightInorder);
        return root;
    }
}
