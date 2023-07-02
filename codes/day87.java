public class day87 {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        long score = 0;
        int nc = 0;
    }

    int nodecount(TreeNode root){
        if(root==null){
            return 0;
        }
        root.nc = nodecount(root.left) + nodecount(root.right) + 1;
        return root.nc;
    }
    public int countHighestScoreNodes(int[] parents) {
        long max = 0;
        int n = parents.length;
        int ans = 0;
        TreeNode[] tree = new TreeNode[n];
        for(int i=0;i<n;i++){
            tree[i] = new TreeNode();
        }
        for(int i=1;i<n;i++){
            int pid = parents[i];
            if(tree[pid].left==null){
                tree[pid].left = tree[i];
            }
            else{
                tree[pid].right = tree[i];
            }
        }
        nodecount(tree[0]);
        for(int i=0;i<n;i++){
            long product = 1;
            int leftcnt = tree[i].left == null ? 0 : tree[i].left.nc;
            int rightcnt = tree[i].right == null ? 0 : tree[i].right.nc;
            int parentcnt = n-1-leftcnt-rightcnt;
            if(leftcnt>0){
                product*=leftcnt;
            }
            if(rightcnt>0){
                product*=rightcnt;
            }
            if(parentcnt>0){
                product*=parentcnt;
            }
            tree[i].score = product;
            max = Math.max(max, product);
        }
        for(int i=0;i<n;i++){
            if(tree[i].score==max){
                ans++;
            }
        }
        return ans;
    }
}
