public class day60 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int e : to_delete){
            set.add(e);
        }
        ArrayList<TreeNode> ans = new ArrayList<>();
        helper(root, set, ans);
        if(!set.contains(root.val)){
            ans.add(root);
        }
        return ans;
    }

    TreeNode helper(TreeNode root, HashSet<Integer> set, ArrayList<TreeNode> ans){
        if(root==null){
            return null;
        }
        root.left = helper(root.left, set, ans);
        root.right = helper(root.right, set, ans);

        if(set.contains(root.val)){
            if(root.left!=null){
                ans.add(root.left);
            }
            if(root.right!=null){
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
    
}
