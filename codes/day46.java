import java.util.*;

public class day46 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null){
            return -1;
        }
        List<Integer> lst = new ArrayList<>();
        dfs(root, lst);
        Collections.sort(lst);
        if(lst.size()==1){
            return -1;
        }
        return lst.get(1);
        
    }

    void dfs(TreeNode root, List<Integer> lst){
        if(root==null){
            return;
        }
        else{
            if(!lst.contains(root.val)){
                lst.add(root.val);
            }
            dfs(root.left, lst);
            dfs(root.right, lst);
        }
    }
}
