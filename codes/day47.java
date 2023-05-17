import java.util.*;
public class day47 {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while(!q.isEmpty()){
            sum = 0;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                sum+=temp.val;
                if(temp.right!=null){
                    q.offer(temp.right);
                }
                if(temp.left!=null){
                    q.offer(temp.left);
                }
            }
            
        }
        return sum;
    }
}
