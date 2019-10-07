import java.util.List;
/*
       1 2 4 # # # 3 # #
       0 1 2 3 4 5 6 7 8
         ---------
            左5    ------
                    右3
     知道二叉树的前序遍历（带空结点）创建二叉树
 */
public class BuildBinaryTree {
    private static class Node{   //每一个结点
        private int val;
        private Node left=null;
        private Node right=null;

        private Node(int val){
            this.val=val;
        }
    }

    private static class Return{  //返回值
        private Node root;  //二叉树的根
        private int count;  //二叉树的结点个数

        private Return(){}
        private Return(Node root,int count){
            this.root=root;
            this.count=count;
        }
    }

    Return buildTree5(List<Integer> preorder){
        Return returnValue=new Return();//定义返回值
        if(preorder.size()==0){
            returnValue.root=null;
            returnValue.count=0;
            return returnValue;
            //return new Return(null,0);
        }
        int rootValue=preorder.get(0);//根结点的值
        if(rootValue=='#'){
            returnValue.root=null;
            returnValue.count=1;
            return returnValue;
            //return new Return(null,1);
        }
        Return leftTree=buildTree5(preorder.subList(1,preorder.size()));
        Return rightTree=buildTree5(preorder.subList(1+leftTree.count,preorder.size()));

        Node root=new Node(rootValue);  //根结点
        root.left=leftTree.root;   //根结点的左子树
        root.right=rightTree.root; //根结点的右子树

        returnValue.root=root;
        returnValue.count=1+leftTree.count+rightTree.count;
        return returnValue;
        //return new Return(root,1+leftTree.count+rightTree.count);
    }
}
