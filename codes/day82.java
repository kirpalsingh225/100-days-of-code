import java.util.LinkedList;
import java.util.Queue;

public class day82 {
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null) return true;
        boolean evenlvl = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            int prev = evenlvl ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                if(evenlvl && (temp.val%2==0 || temp.val<=prev)) 
                    return false;
                if(!evenlvl && (temp.val%2==1 || temp.val>=prev)) 
                    return false;
                prev = temp.val;
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
                
            }
            evenlvl = !evenlvl;
        }
        return true;
    }
}
