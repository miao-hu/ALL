/*
    搜索树的中序遍历是有序的
    搜索树的任一结点的左子树的值小于该结点的值，右子树的值大于该结点的值
 */
public class BinarySearchTree {
   public static class Node{
       int key;
       Node left;
       Node right;

       public Node(int key){
           this.key=key;
       }
   }

   private Node root=null;  //首先根结点为空

    //在搜索树中查找值为key的结点，如果找到，返回 key 所在的结点，否则返回 null
    public Node search(int key){
        Node cur=root;
        while(cur!=null){
            if(key==cur.key){
                return cur;
            }else if(key<cur.key){
                cur=cur.left;
            }else{
                cur=cur.right;
            }
        }
        return null;  //找遍所有的结点还是没有找到返回null
    }

    /*  插入一个结点  true 表示插入成功, false 表示插入失败
        插入结点  要找到他的前驱结点  故设置变量parent
        若原树中有该值的结点  直接返回错误
    */
    public boolean insert(int key){
        if(root==null){   //空树
            root=new Node(key);
            return true;
        }
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(key==cur.key){  //该值在原树中已经存在
                return false;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        Node node=new Node(key);
        if(key<parent.key){
            parent.left=node;
        }else{
            parent.right=node;
        }
        return true;
    }

    /*  删除成功返回 true，失败返回 false
        删除一个节点要知道它的前驱结点
     */
    public boolean remove(int key){
        Node cur=root;
        Node parent=null;
        while(cur!=null){
            if(key==cur.key){  //该值在原树中存在
                removeNode(parent,cur);
                return true;
            }else if(key<cur.key){
                parent=cur;
                cur=cur.left;
            }else{
                parent=cur;
                cur=cur.right;
            }
        }
        return false;  //该值在原树中不存在，无法删除，返回false
    }

    private void removeNode(Node parent, Node cur) {
        if(cur.left==null){
            if(cur==root){
                root=cur.right;
            }else if(cur== parent.left){
                parent.left=cur.right;
            }else {
                parent.right=cur.right;
            }
        }else if(cur.right==null){
            if(cur==root){
                root=cur.left;
            }else if(cur==parent.left){
                parent.left=cur.left;
            }else{
                parent.right=cur.left;
            }
        }else{ //替罪羔羊为右子树结点值最小的结点，采用替换法
            Node goatParent=cur;
            Node goat=cur.right;
            while(goat.left!=null){
                goatParent=goat;
                goat=goat.left;
            }
            cur.key=goat.key;
            if(goat==goatParent.left){
                goatParent.left=goat.right;
            }else{
                goatParent.right=goat.right;
            }
        }
    }

    public static void main(String[] args) {
        // 1. 创建搜索树(搜索树的中序遍历是有序的）
        // 2. 随机插入一些数据
        // 3. 打印前序 + 中序遍历
        // 4. 查找固定的值
        BinarySearchTree tree=new BinarySearchTree();
        int[] a={ 3, 9, 7, 4, 1, 6, 2, 8, 5 };
        for(int e:a){
            tree.insert(e);  //往搜索树中插入元素
        }
        System.out.print("搜索树的前序遍历：");
        preOrder(tree.root);
        System.out.println();
        System.out.print("搜索树的中序遍历：");
        inOrder(tree.root);
        System.out.println();
        System.out.println("插入重复元素:"+tree.insert(7));   //false
        System.out.println("查找结点:"+tree.search(1));//查找结点:BinarySearchTree$Node@1b6d3586
        System.out.println("查找结点:"+tree.search(5).key); //打印结点的值
        System.out.println("查找结点:"+tree.search(7).key);
        tree.remove(5);
        inOrder(tree.root);
        System.out.println();
        tree.remove(3);
        inOrder(tree.root);
    }

    private static void inOrder(Node root) {
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.key+" ");
            inOrder(root.right);
        }
    }

    private static void preOrder(Node root) {
        if(root!=null){
            System.out.print(root.key+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
