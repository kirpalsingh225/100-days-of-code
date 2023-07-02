import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day85 {
    List<Integer> ans = new ArrayList<>();
    int i = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfs(root, voyage) ? ans : Arrays.asList(-1);
    }

    boolean dfs(TreeNode root, int[] voyage){
        if(root==null){
            return true;
        }
        if(root.val!=voyage[i++]){
            return false;
        }
        if(root.left!=null && root.left.val!=voyage[i]){
            ans.add(root.val);
            return dfs(root.right, voyage) && dfs(root.left, voyage);
        }
        return dfs(root.left, voyage) && dfs(root.right, voyage);
    }
}
