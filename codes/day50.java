import java.util.*;
public class day50 {
    public int averageOfSubtree(TreeNode root) {
        if(root.left==null && root.right==null){
            return 1;
        }
        int count = 0;
        List<TreeNode> nodes = new ArrayList<>();
        getNodes(nodes, root);
        
        
        for(TreeNode i : nodes){
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(i);
            int n = 0;
            int sum = 0;
            while(!q.isEmpty()){
                for(int j=0;j<q.size();j++){
                    TreeNode temp = q.poll();
                    n++;
                    sum+=temp.val;
                    if(temp.left!=null){
                        q.offer(temp.left);
                    }
                    if(temp.right!=null){
                        q.offer(temp.right);
                    }
                }
            }
            int avg = sum/n;
            if(avg==i.val){
                count++;
            }
        }
        return count;

    }

    void getNodes(List<TreeNode> nodes, TreeNode root){
        if(root==null){
            return;
        }
        nodes.add(root);
        getNodes(nodes, root.left);
        getNodes(nodes, root.right);
    }
}
