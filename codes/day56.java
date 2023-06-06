public class day56 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        TreeNode root = null;
        return helper(nums, root, left, right);
    }

    TreeNode helper(int[] nums, TreeNode root, int left, int right){
        if(left>right){
            return null;
        }
        int pos = getMax(nums, left, right);

        root = new TreeNode(nums[pos]);
        root.left = helper(nums, root.left, left, pos-1);
        root.right = helper(nums, root.right, pos+1, right);
        return root;
    }
    
    int getMax(int[] nums, int left, int right){
        int val = Integer.MIN_VALUE;
        int idx = -1;

        for(int i=left;i<=right;i++){
            if(nums[i]>val){
                val = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
