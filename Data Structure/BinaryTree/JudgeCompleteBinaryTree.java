import java.util.LinkedList;
import java.util.Queue;

/*
    判断一棵二叉树是不是完全二叉树
    按照层序遍历的方式
    完全二叉树的右边是连续的null
    队列先进先出，采用链表实现
 */
public class JudgeCompleteBinaryTree {
    private static class Node{
        char val;
        Node left=null;
        Node right=null;
        private Node(char val){
            this.val=val;
        }
    }

    public static boolean isCompleteTree(Node root){
        if(root==null){
            return true;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(true){
            Node front=queue.poll();
            if(front==null){  // 找到第一个空结点就退出，判断他的后边是否全为空
                break;
            }
            queue.offer(front.left);
            queue.offer(front.right);
        }
        // 去检查队列中的剩余结点是否全为 null 了
        while(!queue.isEmpty()){
            Node n=queue.poll();
            if(n!=null){   //只要有一个结点不为空 那么就不是完全二叉树
                return false;
            }
        }
        return true;
    }
}
