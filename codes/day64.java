import java.util.LinkedList;
import java.util.Queue;

public class day64 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        int ans = -1;
        int maxSum = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int sum = 0;
            level++;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                sum+=temp.val;
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            if(sum>maxSum){
                ans = level;
                maxSum = sum;
            }
        }
        return ans;

    }
}
