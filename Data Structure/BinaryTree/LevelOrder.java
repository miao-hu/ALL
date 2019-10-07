import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder{
    private static class Node{
        char val;
        Node left=null;
        Node right=null;
        private Node(char val){
            this.val=val;
        }
    }

    //将二叉树进行层序遍历
    public static void levelOrder(Node root){
        if(root==null){
            return ;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node front=queue.poll();
            System.out.print(front.val+" ");;
            if(front.left!=null){
                queue.offer(front.left);
            }
            if(front.right!=null){
                queue.offer(front.right);
            }

        }
    }

	//将二叉树进行层序遍历(结果显示一个二维数组)
    public List<List<Integer>> levelOrder2(Node root){
		List<List<Integer>> list=new ArrayList<List<Integer>>();
		if(root==null)return list;  //返回一个空表
		Queue<Node> queue=new LinkedList<>();//队列先进先出
		queue.add(root);
		int level=0;  //记录结点的层数
		while(!queue.isEmpty()){
			list.add(new ArrayList<Integer>()); //增加一个一维数组
			int count=queue.size();
			for(int i=0;i<count;i++){
				Node front=queue.remove();
				list.get(level).add(front.val);
				if(front.left!=null)queue.add(front.left);
				if(front.right!=null)queue.add(front.right);
			}
			level++;
		}
		return list;
	}
	
    //建立一颗二叉树
    public static Node buildTree() {
        Node a = new Node('A');
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

        return a;
    }

    //将二叉树进行层序遍历，并且打印出每个结点在第几层
    private static class NodeLevel{
        private Node node;
        private int level;

        private NodeLevel(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }

    public static void levelOrder2(Node root){
        if(root==null){
            return ;
        }
        Queue<NodeLevel> queue=new LinkedList<>();
        queue.offer(new NodeLevel(root,1));
        while(!queue.isEmpty()){
            NodeLevel front=queue.poll();
            System.out.println(front.level+"--"+front.node.val);
            if(front.node.left!=null){
                queue.offer(new NodeLevel(front.node.left,front.level+1));
            }
            if(front.node.right!=null){
                queue.offer(new NodeLevel(front.node.right,front.level+1));
            }
        }

    }

    public static void main(String[] args) {
        Node root=buildTree();
        levelOrder(root);
        levelOrder2(root);
    }
}
