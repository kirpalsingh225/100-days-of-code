import java.util.*;
public class day53 {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null){
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            level++;
            if(level%2==1 && !q.isEmpty()){
                int[] nums = new int[q.size()];
                int i = 0;
                for(TreeNode t : q){
                    nums[i] = t.val;
                    i++;
                }

                int j = q.size()-1;
                for(TreeNode t : q){
                    t.val = nums[j];
                    j--;
                }
            }
        }
        return root;
    }
}
