import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class day76 {
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        helper(map, root);
        return ans;
    }

    String helper(Map<String, Integer> map, TreeNode root){
        if(root==null){
            return "$";
        }
        String left = helper(map, root.left);
        String right = helper(map, root.right);

        String s = left + "," + right + "," + root.val;
        if(map.getOrDefault(s,0)==1){
            ans.add(root);
        }
        map.put(s, map.getOrDefault(s,0)+1);
        return s;
    }
}
