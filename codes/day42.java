public class day42 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        dfs(nodes, root);
        return nodes;
    }

    void dfs(List<Integer> nodes, TreeNode root){
        if(root==null){
            return;
        }
        else{
            dfs(nodes, root.left);
            dfs(nodes, root.right);
            nodes.add(root.val);
        }
    }
}
