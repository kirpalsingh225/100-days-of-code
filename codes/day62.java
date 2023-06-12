import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class day62 {
    void dfs(List<Integer> sum, TreeNode root, int level){
        if(root==null){
            return;
        }
        int var = 0;
        if(root.left!=null){
            var+=root.left.val;
        }
        if(root.right!=null){
            var+=root.right.val;
        }
        if(root.left!=null){
            root.left.val = sum.get(level+1)-var;
        }
        if(root.right!=null){
            root.right.val = sum.get(level+1)-var;
        }

        dfs(sum, root.left, level+1);
        dfs(sum, root.right, level+1);
        return;
    }

    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> sum = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int n = q.size();
            int sze = 0;
            for(int i=0;i<n;i++){
                TreeNode temp = q.poll();
                sze +=temp.val;
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            sum.add(sze);
        }

        if(root!=null){
            root.val = 0;
        }
        dfs(sum, root, 0);
        return root;
    }
}
