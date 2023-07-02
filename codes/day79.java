import java.util.ArrayList;
import java.util.List;

public class day79 {
     List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new ArrayList<>());
        return ans;
    }

    void helper(TreeNode root, int targetSum, List<Integer> lst){
        if(root==null){
            return;
        }
        
        lst.add(root.val);
        helper(root.left, targetSum, lst);
        if(root.left==null && root.right==null){
            int res = calcSum(lst);
            if(res==targetSum){
                ans.add(new ArrayList(lst));
            }
        }
        helper(root.right, targetSum, lst);
        lst.remove(lst.size()-1);

    }

    int calcSum(List<Integer> lst){
        int sum = 0;
        for(int x : lst){
            sum+=x;
        }
        return sum;
    }
}
