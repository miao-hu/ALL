public class IsSameTree {
    public boolean isSameTree(Node p, Node q) {
        if (p == null && q == null) {  //两个都是空树
            return true;
        }
        if (p == null || q == null){//只有一个成立
            return false;
        }
        return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);

    }
}
