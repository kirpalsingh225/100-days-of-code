public class day58 {
    int ans = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        helper(root);
        return ans;
    }

    void helper(TreeNode root){
        if(root==null){
            return;
        }

        calcMax(root, root);
        helper(root.left);
        helper(root.right);
    }

    void calcMax(TreeNode curr, TreeNode root){
        if(curr==null){
            return;
        }
        ans = Math.max(ans, Math.abs(root.val-curr.val));
        calcMax(curr.left, root);
        calcMax(curr.right, root);
    }
}
