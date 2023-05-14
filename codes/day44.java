public class day44 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        height(root, ans);
        return ans[0];
    }

    int height(TreeNode root, int[] ans){
        if(root==null){
            return 0;
        }
        int lh = height(root.left, ans);
        int rh = height(root.right, ans);
        ans[0] = Math.max(ans[0], lh+rh);
    }
}
