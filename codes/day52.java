import java.util.*;
public class day52{
    List<Integer> ans = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        helper(root1);
        helper(root2);
        Collections.sort(ans);
        return ans;
    }

    void helper(TreeNode root){
        if(root==null){
            return;
        }
        ans.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}