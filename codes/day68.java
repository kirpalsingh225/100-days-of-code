public class day68 {
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        helper(root, true, 0);
        helper(root, false, 0);
        return ans;
    }

    void helper(TreeNode root, boolean direction, int steps){
        if(root==null){
            return;
        }
        ans = Math.max(ans, steps);
        if(direction){
            helper(root.left, false, steps+1);
            helper(root.right, true, 1);
        }
        else{
            helper(root.right, true, steps+1);
            helper(root.left, false, 1);
        }
    }
}
