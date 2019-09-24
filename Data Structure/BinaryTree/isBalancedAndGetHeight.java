public class R {
    boolean isBalanced;
    int height;

    public R(boolean isBalanced, int height){
        this.isBalanced=isBalanced;
        this.height=height;
    }

    public R isBalancedAndGetHeight(Node root){
        if(root==null){
            return new R(true,0);
        }
        R left=isBalancedAndGetHeight(root.left);
        if(!(left.isBalanced)) return new R(false,-1);
        R right=isBalancedAndGetHeight(root.right);
        if(!(right.isBalanced)) return new R(false,-1);
        return new R(false,-1);
    }
}
