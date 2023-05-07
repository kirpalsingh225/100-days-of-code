/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class day37{
    TreeNode target, res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        this.target = target;
        dfs(original, cloned);
        return res;
    }

    void dfs(TreeNode original, TreeNode cloned){
        if(original!=null){
            dfs(original.left, cloned.left);
            if(original==target){
                res=cloned;
            }
            dfs(original.right, cloned.right);
        }
    }
}