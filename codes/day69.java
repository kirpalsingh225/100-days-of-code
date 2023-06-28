import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class day69 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()){
            level++;
            int n = q.size();
            List<Integer> lst = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                lst.add(temp.val);
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            if(level%2==0){
                Collections.reverse(lst);
                ans.add(lst);
            }
            else{
                ans.add(lst);
            }
        }
        return ans;
    }
}
