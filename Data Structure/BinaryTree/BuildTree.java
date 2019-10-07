import java.util.List;
/*
根据一棵树的前序遍历与中序遍历构造二叉树。
 */

public class BuildTree {
    private static class Node{
        private int val;
        private Node left=null;
        private Node right=null;
        private Node(int val){
            this.val=val;
        }
    }

    Node buildTree(List<Integer> preorder, List<Integer> inorder){
        if(preorder.isEmpty()){
            return null;
        }
        int rootValue=preorder.get(0); //得到根结点的值
        int leftCount=inorder.indexOf(rootValue);//在inorder中查找值为rootValue的元素的下标
        List<Integer> leftPreorder=preorder.subList(1,1+leftCount);
        List<Integer> leftInorder=inorder.subList(0,leftCount);
        List<Integer> rightPreorder=preorder.subList(1+leftCount,preorder.size());
        List<Integer> rightInorder=inorder.subList(leftCount+1,inorder.size());

        Node root=new Node(rootValue);
        root.left=buildTree(leftPreorder,leftInorder);
        root.right=buildTree(rightPreorder,rightInorder);
        return root;
    }
}
