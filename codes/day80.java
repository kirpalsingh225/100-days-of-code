import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class day80 {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    TreeNode temp = null;
    int ans = 0;
    public int amountOfTime(TreeNode root, int start) {
        Set<TreeNode> visited = new HashSet<>();
        getaddress(start, root);
        getParent(parent, root);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(temp);
        while(!q.isEmpty()){
            ans++;
            int n = q.size();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                visited.add(node);
                if(parent.containsKey(node) && !visited.contains(parent.get(node))){
                    q.add(parent.get(node));
                }
                
                if(node.left != null && !visited.contains(node.left)){
                    q.add(node.left);      
                }
                
                if(node.right != null && !visited.contains(node.right)){
                    q.add(node.right);      
                }
            }
        }
        return ans-1;
    }

    void getParent(Map<TreeNode, TreeNode> parent, TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parent.put(root.left, root);
        }
        if(root.right!=null){
            parent.put(root.right, root);
        }
        getParent(parent, root.left);
        getParent(parent, root.right);
    }

    void getaddress(int start, TreeNode root){
        if(root==null){
            return ;
        }
        else if(root.val==start){
            temp = root;
        }
        getaddress(start, root.left);
        getaddress(start, root.right);
    }
}
