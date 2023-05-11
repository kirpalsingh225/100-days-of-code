public class day41 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }

        TreeNode root = bst(nums, 0, nums.length-1);
        return root;
    }

    TreeNode bst(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(nums, start, mid-1);
        root.right = bst(nums, mid+1, end);
        return root;

    }
}
