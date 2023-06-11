public class day61 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null){
            return null;
        }
        int lh = depth(root.left);
        int rh = depth(root.right);

        if(lh==rh){
            return root;
        }
        else{
            if(lh>rh){
                return subtreeWithAllDeepest(root.left);
            }
            else{
                return subtreeWithAllDeepest(root.right);
            }
        }
    }

    int depth(TreeNode root){
        if(root==null){
            return 0;
        }

        return 1+Math.max(depth(root.left), depth(root.right));
    }
}
