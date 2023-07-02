public class day83 {
    int lc, rc;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        lc=0;
        rc=0;
        count(x, root);
        int var = n - (lc+rc+1);
        int max = Math.max(var, Math.max(lc, rc));
        return max>(n/2);
    }

    int count(int x, TreeNode root){
        if(root==null){
            return 0;
        }
        int left = count(x, root.left);
        int right = count(x, root.right);
        if(root.val==x){
            lc=left;
            rc=right;

        }
        return left+right+1;
    }
}
