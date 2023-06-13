public class day63 {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        helper(root, arr);
        return count;
    }

    void helper(TreeNode root, int[] arr){
        if(root==null){
            return ;
        }
        arr[root.val]++;
        helper(root.left, arr);
        helper(root.right, arr);

        if(root.left==null && root.right==null){
            int flag = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]%2!=0){
                    flag++;
                }
            }
            if(flag==0 || flag==1){
                count++;
            }
        }
        arr[root.val]--;
    }
}
