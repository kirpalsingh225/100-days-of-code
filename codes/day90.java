import java.util.Deque;
import java.util.LinkedList;

public class day90 {
    class pair{
        TreeNode node;
        int val;
        pair(TreeNode node, int val){
            this.node = node;
            this.val = val;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        Deque<pair> q = new LinkedList<>();
        q.offer(new pair(root, 0));
        while(!q.isEmpty()){
            int n = q.size();
            int start = q.peek().val;
            int end = q.getLast().val;
            ans = Math.max(ans, end-start+1);
            for(int i=0;i<n;i++){
                pair p = q.poll();
                TreeNode t = p.node;
                int v = p.val;
                if(t.left!=null){
                    q.offer(new pair(t.left, 2*v+1));
                }
                if(t.right!=null){
                    q.offer(new pair(t.right, 2*v+2));
                }
            }
        }
        return ans;
    }
}
