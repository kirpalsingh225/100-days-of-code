public class day54 {
    int count = 0;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return count;
    }

    void helper(TreeNode root, int currmax){
        if(root==null){
            return;
        }
        else if(root.val>=currmax){
            count++;
            currmax = Math.max(currmax, root.val);
        }
        helper(root.left, currmax);
        helper(root.right, currmax);
    }
}
