
/*根据二叉树创建字符串:
你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
空节点则用一对空括号 "()" 表示。
而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
输入: 二叉树: [1,2,3,4]
输出: "1(2(4))(3)"

分析：结点左右都为空
      左不为空，右为空
      左为空，右不为空，不能省略
 */

import java.util.List;

public class FromTreeToString {
    private static class Node{
        private int val;
        private Node left=null;
        private Node right=null;
        private Node(int val){
            this.val=val;
        }
    }


    public static String buildTree22(Node root){
        String s="";
        if(root!=null){
            s+="(";
            s+=root.val;
            if(root.left==null&&root.right==null){

            }else if(root.left==null&&root.right!=null){
                s+="()";
                s+=buildTree22(root.right);
            }else if(root.left!=null&&root.right==null){
                s+=buildTree22(root.left);
            }else{
                s+=buildTree22(root.left);
                s+=buildTree22(root.right);
            }
            s+=")";
            return s.substring(1,s.length()-1);//去掉最左边和最右边的括号
        }else{
            return " ";//为空树返回空字符串
        }
    }

}
