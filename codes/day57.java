public class day57 {
    Boolean ans = false;

    boolean match(TreeNode root, TreeNode shoot){
        if(root!=null && shoot!=null){
            boolean a = match(root.left, shoot.left);
            boolean b = match(root.right, shoot.right);
            if(root.val==shoot.val && a && b){
                return true;
            }
            else{
                return false;
            }


        }
        else if(root==null && shoot==null){
            return true;
        }
        else{
            return false;
        }
    }

    void inorder(TreeNode root, TreeNode shoot){
        if(root!=null){
            inorder(root.left, shoot);

            boolean x = match(root, shoot);
            if(x){
                ans = x;
            }
            inorder(root.right, shoot);
        }
    }
    public boolean isSubtree(TreeNode root, TreeNode shoot) {
        inorder(root, shoot);
        return ans;

    }
}
