public class day55 {
    boolean flag = false;
    int oleft = 0;
    int oright = 0;
    public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        oleft=0;
        oright=0;
        oneCalc(root);
        if(oleft==0){
            return null;
        }
        if(oright==0){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }


    void oneCalc(TreeNode root){
        if(root==null){
            return;
        }
        if(root.val==1) oleft++;
        oneCalc(root.left);
        if(root.val==1) oright++;
        oneCalc(root.right);
    }
}
